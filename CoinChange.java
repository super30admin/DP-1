// Time Complexity : O(M*N) // M is number of coins, N is the target amount
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to go through the pattern formation as discussed in the class

/* Approach -
 * build the initial row of matrix and according to tree form a pattern while filling the matrix
 * 999999 used here as min function would return the second value if we compare this value with 999999
 * instead of comparing with -1 as it will result in minimum as -1 which 
 * is incorrect.
 */


// Your code here along with comments explaining your approach


class Solution {
    public int coinChange(int[] coins, int amount) {
    int[][] dp = new int[coins.length+1][amount+1];
    dp[0][0] = 0;
    for(int j=1;j<amount+1;j++){
        dp[0][j] = 999999;
    }

    for(int i=1;i<coins.length+1;i++){
        for(int j=0;j<amount+1;j++){
            if(coins[i-1] > j){
                dp[i][j] = dp[i-1][j];
            } else{
                dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
            }
        }
    }

    if(dp[coins.length][amount] >= 999999){
        return -1;
    } else{
        return dp[coins.length][amount];
    }
    
}
}