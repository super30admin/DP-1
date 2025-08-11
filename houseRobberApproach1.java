// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
    //None

class Solution {
    public int rob(int[] nums) {
        
        //base case
        if(nums == null || nums.length == 0){
            return 0;
        }

        //2D DP matrix
        int[][] dp = new int[nums.length][2];
        //Initialize first row
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        //staring from first index
        for(int i = 1; i < nums.length; i++){
            //case 0 should be filled with Max of previous values of either picking or not picking that house
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            //case 1 will be not picking the previous house + amount obtained by picking the current house
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        //returning the maximum between both the columns of last row
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);

    }
}