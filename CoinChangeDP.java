// Time Complexity : O(n * m) n: no.of element, m : length of the binary tree
// Space Complexity :O(m * n) = n: no.of element, m : length of the binary tree
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this :
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = amount + 1;
        int n = coins.length + 1; 
        int[][] dp = new int[n][m];
            
        for(int i = 0; i<n; i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i<m; i++){
            dp[0][i] = 9999;
        }

        for(int i = 1; i < n;i++){
            for(int j = 1; j < m; j++){
                // if amount < denomination
                if (j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
                }
            }
        }
        if (dp[n-1][m-1] >= 9999) return -1;
        else return dp[n-1][m-1];
    }
}