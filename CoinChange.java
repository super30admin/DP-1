// Time Complexity: O(m*n)
// Space Complexity: O(m*n)

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;

        // Declare a dp array or m + 1 and n + 1, as I am including dummy row for denomination(1) amd dummy column for amount(0)
        int[][] dp = new int[m+1][n+1];

        // Declare the first row, i.e the dummy row to amount + 1 (max amount)
        for(int i=1; i< dp[0].length; i++){
            dp[0][i] = amount + 1;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                // If the amount is less than the each denomiation value then fill the array with the value in its above row
                if(j < coins[i - 1])
                    dp[i][j] = dp[i-1][j];
                // Check for the min
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
            }
        }
        if(dp[m][n] >= amount + 1)
            return -1;
        else return dp[m][n];
    }

}
