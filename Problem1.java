// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int m=coins.length;
        int n=amount;
        int[][] dp=new int[m+1][n+1];
        
        for(int i=1;i<n+1;i++){
            dp[0][i]=amount+1;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        if(dp[m][n]==amount+1){
            return -1;
        }
        return dp[m][n];
        
    }
}