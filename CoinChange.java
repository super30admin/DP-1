//Time Complexity : O(numberOfCoins*TotalAmount)
//Space complexity : O(numberOfCoins*TotalAmount)
public class CoinChange {
    
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        
        int rows = coins.length;
        int cols = amount;
        int dp[][] = new int[rows+1][cols+1];
        
        for(int i = 1; i < cols + 1; i++){
            dp[0][i] = amount + 1;
        }
        
        for(int i = 1; i < rows + 1; i++){
            for(int j = 1; j < cols + 1; j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        if(dp[rows][cols] == amount+1){
            return -1;
        }
        return dp[rows][cols];
    }
}