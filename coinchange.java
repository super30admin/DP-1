// Time Complexity : o(m*n)
// Space Complexity : o(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach


class Solution {
    public int coinChange(int[] coins, int amount) {
        int m=coins.length;
        int n=amount;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int j=1;j<n+1;j++){
            dp[0][j]=amount+1;
        }
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(j-coins[i-1]<0){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        
        if(dp[m][n]==amount+1){
            return -1;
        }else{
            return dp[m][n];
        }
    }
}


