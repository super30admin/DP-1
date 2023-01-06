// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach: We do the repeated subproblem approach by building a matrix for m(coins) and n(amount).
// For n amount have have 2 conditions, choose or dont choose.
// We take the minimum of both which would be the resultant i,j in the matrix. Finally return the value of the last m*n cell.
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m=coins.length; //rows
        int n=amount;
        int dp[][] = new int[m+1][n+1]; //extra because of dummy
        for(int j=1;j<=n;j++){
            dp[0][j]=amount+1; //infinity
        }
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                //till amount < coin denomination
                if(j<coins[i-1]){ 
                    dp[i][j]=dp[i-1][j]; //one row above
                } else {
                            // 0 case 1 row above, 1 case same row - coin denomination
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[m][n] > amount) return -1; //out of bounds
        return dp[m][n];
    }
}