class CoinChange {
     //recursion exhaustive approach
     //time complexity : amount ^ coins
    //space complexity : number of coins
     public int coinChangeRecursion(int[] coins, int amount) {
         return helper(coins, 0, amount, 0) == Integer.MAX_VALUE ? -1: helper(coins, 0, amount, 0) ;
     }

     private int helper(int[] coins, int index, int amount, int numberOfCoins){

         if(amount == 0){
             return numberOfCoins;
         }

         if(amount < 0 || index >= coins.length) {
             return Integer.MAX_VALUE;
         }

         //logic
         //case 1 choose the current coin;
         int case1 = helper(coins, index, amount - coins[index], numberOfCoins + 1);
         //case 2 skip the current coin.
         int case2 = helper(coins, index + 1, amount, numberOfCoins);

         return Math.min(case1, case2);
     }

//    dp approach bottom up tabulation
//    time complexity: amount * number of coin denominations provided
//    space complexity amount * number of coin denominations provided
     public int coinChangeDpTabulation(int[] coins, int amount) {

         int[][] dp = new int[coins.length + 1][amount + 1];

         dp[0][0] = 0;

         for(int index = 1; index <= amount; index++) {
             dp[0][index] = 99999;
         }

         for(int row = 1; row <= coins.length; row++) {
             for(int col = 0; col <= amount; col++) {
                 if(col < coins[row - 1]) {
                     dp[row][col] = dp[row - 1][col];
                 }
                 else{
                     dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - coins[row - 1]] + 1);
                 }
             }
         }
         return dp[coins.length][amount] == 99999 ? -1: dp[coins.length][amount] ;
     }

    //dp approach bottom up tabulation
    //time complexity: amount * number of coin denominations provided
    //space complexity(optimized) amount
    public int coinChangeDpOptimized(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        dp[0] = 0;

        for(int index = 1; index <= amount; index++) {
            dp[index] = 99999;
        }

        for(int row = 1; row <= coins.length; row++) {
            for(int col = 0; col <= amount; col++) {
                if(col >= coins[row - 1]) {
                    dp[col] = Math.min(dp[col], dp[col - coins[row - 1]] + 1);
                }
            }
        }
        return dp[amount] == 99999 ? -1: dp[amount] ;
    }
}
