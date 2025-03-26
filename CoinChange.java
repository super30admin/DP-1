package s30.week2;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int re = helper(coins, 0, amount, 0);
        if(re == Integer.MAX_VALUE) {
            return -1;
        }
        return re;
    }

    private int helper(int[] coins, int i, int amount, int coinsUsed) {
        if(amount == 0) {
            return coinsUsed;
        }
        if(i == coins.length || amount < 0) return Integer.MAX_VALUE;

        //dont choose
        int case0 = helper(coins, i+1, amount, coinsUsed);

        //chose
        int case1 = helper(coins, i, amount - coins[i], coinsUsed++);

        return Math.min(case0, case1);
    }


    //using dp
    public int coinChangeDP(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];

        for(int j = 0; j <= n ; j++) {
            dp[0][j] = 99999;
        }

        for(int i = 1 ; i <= m ; i++) {
            for(int j = 0 ; j <= n; j++) { //j is the columns/ sub-amount
                if(j < coins[i-1]) { // amount < denomination of the coin
                    // Consider this example for when we have to make 1,2,3,4 with coin [1,2,5]
                    // In this case 5 can't help make [1, 2, 3 ,4] hence we just rely on [1,2]
                    // this implies no choose case
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] , 1 + dp[i][j-coins[i-1]]);
                }
            }
        }

        if(dp[m][n] == 99999) return -1;
        return dp[m][n];
    }
}
