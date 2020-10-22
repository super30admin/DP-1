// Time Complexity : O(MN) - M coins, N Amount
// Space Complexity :O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0 || coins.length == 0 ) return 0;
        int[][] dp = new int[coins.length + 1] [amount + 1];
        int m = dp.length;
        int n = dp[0].length;
        for(int i=1;i<n;i++){
            dp[0][i] = amount + 1;
        }
        
        for(int i=1;i<m;i++){
            for(int j =1;j<n;j++){
                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(dp[i-1][j] ,1 + dp[i][j-coins[i-1]]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        if(dp[m-1][n-1] >= amount + 1){
            return -1;
        }
        return dp[m-1][n-1];
    }
}