//Time complexity: O(m*n) || m is the number of coins and n is the amount
//Space Complexity: O(m*n) 
//Program ran successfully
/*
    Algorithm: 1. The recusrive tree of the problem exhibits overlapping subproblems
               2. Dynamic programming is used here - Bottom up approach
               3. A 2 dimension array is created to record values and are used in further computations in order to optimize the solution
*/

class coin {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 1; i < dp[0].length; i++){
            dp[0][i] = 9999;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[dp.length-1][dp[0].length-1] >= 9999) return -1;
        return dp[dp.length-1][dp[0].length-1];
    }
    
}
