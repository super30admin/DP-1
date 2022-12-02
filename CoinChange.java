// Time Complexity : O(mn)
// Space Complexity : O(mn)

//https://leetcode.com/problems/coin-change/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m= coins.length;
        int minCoins =0;
        int n= amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0]=0;
        for(int j=1;j<=n;j++){
            dp[0][j]=amount+1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j<coins[i-1]) {
                    dp[i][j]=dp[i-1][j];
                } else{
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[m][n] >=amount+1) return -1;
        return dp[m][n];
    }
}
