public class Solution {
    public int knapsack(int[] val, int[] wt, int capacity) {
        if( val == null || wt == null || wt.length != val.length) {
            return -1;
        }
        int [][] dp = new int[wt.length][capacity + 1];
        for(int i = 0; i < wt.length; i++) {
            dp[i][0] = 0;
        }
        for(int i = 0; i < wt.length; i++) {
            for(int j = 1; j < capacity + 1; j++) {
                if(j < wt[i]) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i] + dp[i - 1][j - wt[i]]);
                }
            }
        }
        return dp[wt.length - 1][capacity];
    }
}
