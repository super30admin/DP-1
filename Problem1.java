//Time Complexity : O(m*n)
// Space Complexity : O(n) for the 1D dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Three line explanation of solution in plain english:
//1. We are using a 2D dp array to store the minimum number of coins needed to make each amount
//2. We iterate through the coins and for each coin, we update the dp array to reflect the minimum number of coins needed for each amount
//3. The final result is the value in dp[n][m], where n is the number of coins and m is the target amount. If this value is greater than or equal to a large number (99999), we return -1, indicating that it is not possible to make the amount with the given coins.
class Solution {
    public int coinChange(int[] coins, int amount) {
        //
        int n=coins.length;
        int m=amount;
        int result=0;
        // Initialize a 2D dp array with size (n+1) x (m+1)
        int[][] dp=new int[n+1][m+1];
        // Fill the first column with to indicate that no coins are needed for amount 0
        for(int i = 1; i <= n; i++){
           dp[i][0] = 0;
       }
        // Fill the first row with a large number as a dummy column
        for(int j = 1; j <= m; j++){
           dp[0][j] = 99999; 
       }
        // Fill the dp array using the bottom-up approach
        //we start the outer loop from 1 to n coins and inner loop with 1 to m amount
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                // If the current amount is less than the coin value, we cannot use this coin
                // So we take the value from the previous row (not using this coin)
                if (j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                // If the current amount is greater than or equal to the coin value, we have two options:
                // 1. Not using this coin, which is the value from the previous row 
                // 2. Using this coin, which is 1 plus the value from the same row but with the amount reduced by the coin value
                // We take the minimum of these two options
                else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
                
            }
        }
        // The result is the value in the last cell of the dp array, which represents the minimum number of coins needed to make the amount
        result=dp[n][m];
        if(result >= 99999) 
        {
            return -1;
        }    
       else {
        return result;
        }
    }
}