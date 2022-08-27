// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int change(int amount, int[] coins) {
        //null check
        if(coins == null || coins.length == 0) return 0;

        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;

        //top row
        for(int j=1;j<dp[0].length;j++){
            dp[0][j] = amount+1;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //till amount is not equal to denomination
                //not choose case
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
                }
            }
        }
        int result = dp[m][n];

        if(result > amount)
            return -1;

        return result;
    }
}


