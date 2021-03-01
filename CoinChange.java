class Solution {
    public int coinChange(int[] coins, int amount) {
		//Solving Using DP Matrix
        int n = coins.length + 1;
        int m = amount + 1;
        
        int[][] dp = new int[n][m];
        
        //1st row
        for(int j=1; j<m; j++){
            dp[0][j] = 99999; //Leetcode provided Max Value
        }
        
        //1st Col
        for(int i=0; i<n; i++){
            dp[i][0] = 0;
        }
        
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                // Get upper value in table if coin value that needs to be chosen or not chosen is greater than amount that needs to be generated 
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                // Compare upper table value dp[i-1][j] and 1 + left value(pre calculated optimal value for sub problem) retrieved from the table
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        // Final Result
        return dp[n-1][m-1] == 99999 ? -1 : dp[n-1][m-1];
    }
}