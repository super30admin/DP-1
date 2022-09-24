// Time Complexity: O(m*n) - number of coins(m) * amount (n)
// Space Compexity : 0(m*n)
// submission successful on leetcode 
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(coins == null || coins.length==0) return -1;
        
        int m = coins.length;
        int n = amount ;
        
        // since we have 2 decision params, we use 2d array for the same
        
        int[][] dp = new int[m+1][n+1]; // because 0th row and 0th col
        
        // fill 0th row from col 1 to amt with infinity or value >amount as these values 
        // cannot be formed using coin 0
        
        for(int j=1;j<n+1;j++){
            dp[0][j]= amount+1;
        }
        
        // 0th col filled with 0 by default
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                
                // amount is greater than current denomination, we cannot choose it 
                // as we cannot make the desired amount 
                // i-1 because coins[] start from 0 and it corresponds to 1st index of                        dp[][]
                if(j < coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                // adding 1 because we need the count and that too min count of coins
                else{
                    dp[i][j]= Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]); 
                }
            }
        }
        if(dp[m][n]==amount+1){
            return -1;
        } 
        
        return dp[m][n];
    }
}