// Time Complexity : n*k (DP) where, n=number of coins ; k=amount
// Space Complexity : n*k
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this : No

// refered to lecture

// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        //base condition
        if(coins == null)
            return 0;
        
        //initializing 2D array as there are two interdependent variables

        int dp[][] = new int[coins.length+1][amount+1];
        
        //first row is inifinity; initialized
        for(int i=1; i<amount+1;i++){
            dp[0][i] = 9999;
        }
        
        // go through dp aaray and fill the values; minimum is used
        for( int i=1; i<coins.length+1; i++){
            for(int j=1; j<amount+1;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];                   
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        
        //return the result from bottom right index
        int res = dp[coins.length][amount];
        
        //if there is no solution return -1
        if(res == 9999){
            return -1;
        }
        return res;
        
        
    }
}