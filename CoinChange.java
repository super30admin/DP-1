public class CoinChange {
    
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int m = amount;
        int [][] dp = new int [n+1][m+1];
        for (int j = 1; j <=m; j++) {
            dp[0][j] = amount +1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }}
            int result = dp[n][m];
            if(result>=amount+1){
                return -1;
            }  
       return result; 
    

    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
    
}
// Output: 3 (11 can be made with 5 + 5 + 1)
// Time Complexity: O(n*m) where n is the number of coins and m is the amount.
// Space Complexity: O(n*m) for the dp array.   