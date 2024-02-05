// Time Complexity : O(n * m) 
// Space Complexity : O(n * m)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : issues forming the matrix


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int m = amount;
        int[][] dp = new int[n+1][m+1]; // number of coins required to reach the amount (m)
        dp[0][0] = 0;

        //set the first dummy row having zero coins
        for(int i = 1 ; i <= m ; i++){
            dp[0][i] = Integer.MAX_VALUE - 1;
        }

        for(int i = 1 ; i <= n ; i++){ // coins
            for(int j = 1 ; j <= m ; j++){ // amount
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j]; // copy from above because we can not achieve amount i from current coin
                }
                else{
                    //min of not choose and choose
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]]+1);
                }   
            }
        }

        if(dp[n][m] == Integer.MAX_VALUE - 1){
            return -1;
        }
        else{
            return dp[n][m];
        }
        
    }
}