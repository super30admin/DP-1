// Time Complexity : Iterate every cell of DP array O(coins.length)
// Space Complexity : DP array is used to store optimal values. O(2*coins.length)=O(coins.length)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach


class HouseRobber {
    public int rob(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        
        int[][] dp = new int[nums.length][2];
        
        dp[0][0] = 0; dp[0][1] = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < 2; j++){
                if(j == 0){
                    //While not choosing a house, get the max rob value from previous row
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j+1]);
                }else{
                    //While choosing, max value is between the value earned if house not chosen and sum of values  //previous house not chosen plus current house value
                    dp[i][j] = Math.max(nums[i] + dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }
        //return the max of last house chosen and not chosen
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
        
    }
}
