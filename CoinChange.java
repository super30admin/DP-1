class CoinChange {
    //TC:O(amt*n) SC:O(amt)
    public int coinChange(int[] coins, int amount) {
        //null
        if(coins == null || coins.length == 0) return 0;
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        // first row
        for(int j = 1; j < n+1; j++) {
            dp[0][j] = amount+1; 
        }
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(j < coins[i-1]) {
                    //case0
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        if(dp[m][n] > amount) return -1;
        return dp[m][n];
    }
}

// Time limit exceeded
// public int coinChange(int[] coins, int amount) {
//     //null
//     if(coins == null || coins.length == 0) return 0;
//     return lessCoins(coins, amount, 0, 0);
// }

// private int lessCoins(int[] coins, int amount, int i, int coinsUsed) {
//     //base - where should the recursion stop
//     if(amount == 0) return coinsUsed; // validPath
//     if(amount < 0 || i == coins.length) return -1; // invalid path

//     //logic
//     //Case:1 Choose a coin
//     int case1 = lessCoins(coins, amount-coins[i], i, coinsUsed+1);
//     //Case: 0 Don't choose a coin
//     int case0 = lessCoins(coins, amount, i+1, coinsUsed);
//     if(case1 == -1) return case0;
//     if(case0 == -1) return case1;
//     return Math.min(case1, case0);
// }