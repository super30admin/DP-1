/*

Thought Process: Understanding it is a DP problem and understanding how to make the 2D array. Need lot of practice

TC -> O(M * N) where M = number of coins +1 and N = amount + 1
SC -> O(M*N)

*/
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int j=1; j<dp[0].length;j++){
            dp[0][j]=amount+1;
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                // Difficulty initially writing this part of code
                if(coins[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    //  Made mistake here -> Confused on where to put +1
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]]+1);
            }
        }
        
        //  Made mistake here -> Was missing this -ve test case altogether
        if(dp[dp.length-1][dp[0].length-1] == amount+1) return -1;
        
        // Made mistake here -> Making dp[coins.length][amount] whereas should have been +1 or below
        return dp[dp.length -1][dp[0].length-1];
    }
}