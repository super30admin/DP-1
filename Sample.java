class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length + 1;
        int n = amount + 1;

        int[][] dp = new int[m][n];

        for(int i=0; i<n; i++){
            dp[i][0] = 0;
        }

        for(int j=1; j<m; j++){
            dp[0][j] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i][j - coins[i - 1]],dp[i-1][j]);
                }
            }
        } return dp[m - 1][n - 1] == n ? -1 : dp[n - 1][m - 1];
    }
}