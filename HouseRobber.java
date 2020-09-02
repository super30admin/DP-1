// Time Complexity : O(N) where N is the number of houses in a row.
// Space Complexity : O(N) as we are creating another DP array.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : not really

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        int[][] DP = new int[nums.length][2];
        DP[0][0] = nums[0];
        DP[0][1] = 0;
        
        for(int i = 1 ; i < nums.length ; i++) {
            DP[i][0] = nums[i] + DP[i-1][1];
            DP[i][1] = Math.max(DP[i-1][0], DP[i-1][1]);
        }
        
        return Math.max(DP[nums.length - 1][0], DP[nums.length - 1][1]);
    }
}
