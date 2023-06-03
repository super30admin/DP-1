public class CoinChange1 {
    // Recursion Approach
    // public int coinChange(int[] coins, int amount) {
    // return helper(coins,0,amount,0);
    // }
    // private int helper(int[] coins,int idx, int amount,int coinsUsed){
    // //base
    // if(amount==0)
    // return coinsUsed;
    // if(amount<0 || idx==coins.length)
    // return -1;
    // //logic
    // int case1=helper(coins,idx,amount-coins[idx],coinsUsed+1);
    // int case2=helper(coins,idx+1,amount,coinsUsed);
    // if(case1==-1) return case2;
    // if(case2==-1) return case1;
    // return Integer.min(case1,case2);
    // }

    // Using DP- Tabulation
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int dp[][] = new int[coins.length + 1][amount + 1];
        dp[0][0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            dp[0][i] = 999999;
        }
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Integer.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        if (dp[coins.length][amount] >= 999999)
            return -1;
        return dp[coins.length][amount];
    }
}
