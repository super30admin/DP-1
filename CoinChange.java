class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length+1; //rows
        int m = amount+1; //columns
        
        int[][] dp = new int[n][m];
        
        for(int i=0; i<m; i++){
            dp[0][i] = 9999;
        }
        for(int j=0; j<n; j++){
            dp[j][0] = 0;
        }
        
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(j< coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else 
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
            }
        }
        return dp[coins.length][amount] == 9999? -1 : dp[coins.length][amount];
    }
}
//TC:O(n*m)
//SC:O(n*m)
