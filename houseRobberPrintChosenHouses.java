/**
Problem: https://leetcode.com/problems/house-robber/
TC: O(n)
SC: O(n)
*/
class Solution {
    public void printHouses(int nums[], int dp[][]) {
        int n = dp.length - 1;
        int totalProfit = Math.max(dp[n][0], dp[n][1]);
        
        System.out.print("Houses robbed: ");
        for (int i = n; i >= 0 && totalProfit > 0; --i) {
            if (totalProfit == dp[i][1]) { // We robbed house i
                totalProfit -= nums[i];
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }
    
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        // One to represent skip, and another to represent take
        int dp[][] = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        
        for (int i = 1; i < n; ++i) {
            // Case 1 : have not robbed house i
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            // Case 2 : robbing house i
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        printHouses(nums, dp);
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}