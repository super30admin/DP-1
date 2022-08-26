// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, still trying to understand dp

public class Problem1 {
    public int coinChange(int[] coins, int amount) {

        //null check
        if(coins==null || coins.length==0 ) return 0;

        int m = coins.length;
        int n = amount;

        //declaring the 2d dp array
        int[][] dp = new int[m+1][n+1];

        //initializing
        //rest of the array gets null values
        dp[0][0] = 0;


        //top row for infinite amount values
        for(int j=1; j<dp[0].length; j++){

            dp[0][j] = amount+1;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else
                {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }

        }
        int result = dp[m][n];
        if(result> amount) return -1;

        return result;

    }

}
