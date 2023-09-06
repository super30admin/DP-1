class Solution {
    public int coinChange(int[] coins, int amount) {

        //null
        if(coins==null || coins.length == 0) return 0;

        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];

        for(int i=1; i<=n;i++){
            dp[0][i] = 999999;
        }

        for(int i=1; i<dp.length;i++){
            for(int j=1; j<dp[0].length;j++){
                if (j<coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], i+ dp[i][j-coins[i-1]]);
                }
            }
        }

        if(dp[m][n]>amount) return -1;


        return dp[m][n];
        
        
        //return helper(coins, amount, 0, 0);
    }


    //exhaustive solution (Exponential complexity)
    // private int helper(int[] coins,int amount,int i, int coinsUsed){
        
    //     if(amount == 0) return coinsUsed; //Valid path
    //     if(amount<0 || i==coins.length) return -1;


    //     //logic  
    //     //Case 1 //Choosing the coin
    //     int case1 = helper(coins, amount-coins[i], i, coinsUsed+1);

    //     //Case0 //Not choosing the coin
    //     int case0 = helper(coins,amount, i+1, coinsUsed);
    //     if(case1 == -1) return case0;
    //     if(case0 == -1) return case1;
    //     return Math.min(case1, case0);
    // }
}