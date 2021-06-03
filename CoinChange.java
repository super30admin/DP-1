// Time Complexity : m*n
// Space Complexity : m*n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class CoinChange{
    public int coinChange(int[] coins, int amount) {
        //edge
        if(coins == null || coins.length == 0) return -1;

        //int dp matrix
        int[][] dp = new int[coins.length+1][amount+1]; //+1 space for dummy values

        //fill dummy values
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j=1; j<dp[0].length; j++){
            dp[0][j] = amount + 1; // amount+1(the largest number of coins we can use) or 99999
        }

        //logic
        for(int i = 1; i<dp.length ;i++){
            for(int j=1; j<dp[0].length; j++){
                if(j < coins[i -1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] =  Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
            }
        }

        int count  = dp[dp.length-1][dp[0].length-1];
        if(count > amount) return -1;
        return count;
    }

//    public int coinChange(int[] coins, int amount) {
//        return helper(coins, amount, 0, 0);
//    }
//
//    private int helper(int[] coins, int amount, int index, int minCoins){
//        // base
//        if(amount == 0) return minCoins;
//        if(amount < 0 || index == coins.length) return -1;
//
//        // logic
//        // choose coin
//        int case1 = helper(coins, amount - coins[index], index, minCoins + 1);
//        // not choose coin
//        int case2 = helper(coins, amount , index + 1, minCoins);
//        if(case1 == -1) return case2;
//        if(case2 == -1) return case1;
//        return Math.min(case1, case2);
//    }
}