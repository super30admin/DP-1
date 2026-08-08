// Approach - Recursion can be used to pursue exhaustive path, but since this problem has repeated sub problems
// we could use Dynamic programming.
//Time Complexity - O(mxn)
//Space Complexity - O(mxn)

class CoinChange {
    public int coinChange(int[] coins, int amount) {

        //Validate the inputs
        if(coins == null || coins.length == 0){
            return 0;
        }

        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];

        // Fill first row coins[0][j] with any amount higher than the given amount
        for (int j = 1; j <= n; j++){
            dp[0][j] = amount + 1;
        }

        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                // If we don't have the availability of choose case when amount is less than the denomination, copy the above case
                if (j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        if(dp[m][n] == amount+1) return -1;
        return dp[m][n];
    }
}