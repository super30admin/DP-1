public class Problem1 {
    // Time Complexity : O(m*n) where m - number of coins, n - amount
    // Space Complexity : O(m*n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    /* Your code here along with comments explaining your approach
    using dp approach I am creating a 2d array where rows are the number of coins & 
    columns is amount 1- amount
    if the coin value is less than amount, then 
    in each cell of this matrix, I check if we consider this coin or not, if we do not then we take 
    the dp cell one row above current row & if we consider this coin, then add one to the cell value one columns 
    */

    public static void main(String[] aStrings){
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));

    }
    public static int coinChange(int[] coins, int amount){
        if(coins == null || coins.length ==0){
        return -1;
        }

        int[][] dp = new int[coins.length+1][amount+1];
                int m = dp.length;
                int n = dp[0].length;
        for(int j = 1;j< dp[0].length; j++){
            dp[0][j] = amount+1;
        }
        for(int i = 1;i< m; i++){
            for(int j = 1;j<n; j++){
            if(coins[i-1] <= j )
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] +1);
            else{
                dp[i][j] = dp[i-1][j];
                
            }
            
            }
    
        }
        return dp[m-1][n-1] > amount ? -1 : dp[m-1][n-1];  
        }
    
}
