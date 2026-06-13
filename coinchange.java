// Time Complexity : O(n * m)
// Space Complexity : O(n * m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : understanding DP approach and how to fill the table was difficult for me. I had to watch a video to understand the approach and then implement it.


// Your code here along with comments explaining your approach: try all methods to have amount using coins from i. two options: skip coin or use it. return total combination of coins that reach zero after usage.

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int m=amount;
        int[][] dp= new int [n+1][m+1];
        for(int j=1;j<=m;j++){
            dp[0][j]=amount+1;

        }
        for (int i=1; i<=n;i++){
            for(int j=1;j<=m;j++){
                if(coins[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                    else{
                        dp[i][j]=Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                    }
            }
        }
        int res=dp[n][m];
        if(res>=amount+1){
            return -1;
        }
        return res;
    }
}