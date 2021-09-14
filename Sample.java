// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// time and space o(m*n)

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return 0;

        int[][] dp = new int[coins.length+1][amount+1];

        //top row
        for(int j=1; j<dp[0].length; j++){
            dp[0][j] = amount+1;
        }

        for(int i = 1; i< dp.length; i++){
            for( int j=1; j< dp[0].length; j++){
                //amount is lesser than denomination of coin
                if(j < coins[i-1]){
                    //zero case
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    //zero case and 1 case
                    dp[i][j] = Math.min(dp[i-1][j],1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[dp.length-1][dp[0].length-1]>amount) return -1;
        return dp[dp.length-1][dp[0].length-1];
    }
}

class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];

        for(int i = 1; i<dp.length; i++){
            //not choose
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            //chose
            dp[i][1] =dp[i-1][0] + nums[i];

        }
        return Math.max(dp[dp.length-1][0],dp[dp.length-1][1]);
    }
}