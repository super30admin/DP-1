public class CoinChange<T> {
    
    public int coinChange(int[] coins, int amount) {
        int col = amount;
        int[] dp = new int[col+1];
        for (int i=1; i<col+1; i++){
            dp[i] = amount+1;
        }
        for (int i=1; i<coins.length+1; i++){
            for (int j=1; j<col+1; j++){
                // if denomination > amount -> num from above
                if (coins[i-1] > j){
                    dp[j] = dp[j];
                } 
                // get min of above and i-denomnination +1
                else{
                    dp[j] = Math.min(dp[j],1+ dp[j-coins[i-1]]);
                }
            }
        }
        int ans = dp[col];
        if (ans > amount) return -1;
        return ans;
    }

}
