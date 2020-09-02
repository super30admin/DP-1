class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] DP = new int[coins.length+1][amount+1];
        
        for(int i = 1; i <= amount; i++) {
            DP[0][i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i <= coins.length; i++) {
            DP[i][0] = 0;
        }
        
        for(int i = 1 ; i <= coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                if(j < coins[i-1] || DP[i][j-coins[i-1]] == Integer.MAX_VALUE) {
                    DP[i][j] = DP[i-1][j];
                } else {
                    DP[i][j] = Math.min(DP[i-1][j], 1 + DP[i][j-coins[i-1]]);
                }
            }
        }
        
        return DP[coins.length][amount] >= Integer.MAX_VALUE ? -1 : DP[coins.length][amount];
    }
}