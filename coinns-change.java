class Solution {

    /*Time complexity : O(m *n);
     * Space Complexity : O(m*n);
     * 
     * executed in leetcode
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length ==0) return 0;
        int n = coins.length;
        int m = amount;
        int[][] dp = new int[n+1][m+1];
        for (int j=0; j<=m; j++){
            dp[0][j] = 99999;
        }
        for(int i =1; i < dp.length; i++ ){
            for (int j =1; j< dp[0].length ; j++){
                if (j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j- coins[i -1]] + 1);
                }
            }
        }
        if (dp[n][m] >= 99999) return -1;
        return dp[n][m];

        
    }
}