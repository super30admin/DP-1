// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int coinChange(int[] coins, int amount) {
        if( coins==null || coins.length ==0) return -1;
        int m= coins.length;
        int n= amount;
        int[][] dp= new int[m+1][n+1];
        //creating 2d array with 0th column and row thus increasing size
        for(int j=1; j<n+1; j++){
            //making the first row greater than amount in the place of infinity
            dp[0][j]= amount+1;
        }
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(j<coins[i-1]){
                    //then the top cell
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    //minimum of top cell and cell to the left
                    dp[i][j]=Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[m][n] == amount+1){
            return -1;
        }
        return dp[m][n];
    }
}