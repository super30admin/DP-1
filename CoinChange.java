class Solution {
    int count;
    public int coinChange(int[] coins, int amount) {
//int the interview do not jump to 1d matrix.
//first work on 2d matrix and then to optimize u can work on 1d matrix

        /*
        //using DP matrix - 2d matrix
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];
        //dp[0][0] = 0;

        for(int j = 1; j <= n; j++){
            dp[0][j] = 99999;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(j < coins[i-1]){ //amount < denomination of the coins. //[1,2,5] 
                    //no choose case
                    dp[i][j] = dp[i-1][j];

                } else{
                    dp[i][j] = Math.min(dp[i-1][j] , 1+dp[i][j - coins[i-1]]);
                }
            }
        }
        if(dp[m][n] == 99999) return -1;
        return dp[m][n];
*/


//------------------
        //using DP matrix - 1d matrix
        int m = coins.length;
        int n = amount;

        int[] dp = new int[n+1];
        //dp[0][0] = 0;

        for(int j = 1; j <= n; j++){
            dp[j] = 99999;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(j < coins[i-1]){ //amount < denomination of the coins. //[1,2,5] 
                    //no choose case
                    dp[j] = dp[j];

                } else{
                    dp[j] = Math.min(dp[j] , 1+dp[j - coins[i-1]]);
                }
            }
        }
        if(dp[n] == 99999) return -1;
        return dp[n];



/*

        //void based recursive logic
        this.count = Integer.MAX_VALUE;
        helper(coins, 0, amount, 0);
        if(count == Integer.MAX_VALUE) return -1;
        return count;
*/
        
        /*
        //integer based recursive logic
        int re = helper(coins, 0, amount, 0);
        if(re == Integer.MAX_VALUE) return -1;
        return re;
*/
    }
    /*
    private int helper(int[] coins, int i, int amount, int coinsUsed){
        
        //integer based recursive logic
        //base case
        if(amount < 0 || i == coins.length) return Integer.MAX_VALUE;

        if(amount == 0) return coinsUsed;
        
        //dont choose
        int case0 = helper(coins, i+1, amount, coinsUsed);

        //choose
        int case1 = helper(coins, i, amount - coins[i], coinsUsed+1);

        return Math.min(case0, case1);

    }*/
/*
    private void helper(int[] coins, int i, int amount, int coinsUsed){
        //void based recursive logic
        if(amount < 0 || i == coins.length){
            return;
        }
        if(amount == 0){
            count = Math.min(count, coinsUsed);
            return;
        }
        //dont choose
        helper(coins, i+1, amount, coinsUsed);

        //choose
        helper(coins, i, amount - coins[i], coinsUsed+1);
    }
    */
}
