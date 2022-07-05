// Time Complexity :O(n*m) where n is number of coins and m is amount
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public int coinChange(int[] coins, int amount) {
    if(coins == null || coins.length == 0){
        return -1;
    }
    // row of the matrix
    int m = coins.length;
    // column of the matrix
    int n = amount;
    // creating a 2-d array for storing the minimum output
    int[][] dp = new int[m+1][n+1];
    
    //Filling the 0*0 i.e., first row with infinity amount which in this case will be amount+1
    for(int i=1;i<n+1;i++){
        dp[0][i] = amount +1;
    }
    
    //iterating thru the 2-d array and filling it
    for(int i=1;i<m+1;i++){
        for(int j=1;j<n+1;j++){
            if(j < coins[i-1]){ // checking if the amount is less than the coin, if it is then copying the no of coins from above
                dp[i][j] = dp[i-1][j];
            }else{ // if amount is greater than the coin, then adding 1 coin of that denomination and adding total no of coin from previous case.
                dp[i][j] = Math.min(dp[i-1][j],1 + dp[i][j-coins[i-1]]);
            }
        }
    }
    //if the output is still infinity, it means there are no possible combinations then return -1
    if(dp[m][n] == amount+1){
        return -1;
    }
    //return the output stored in the last row and column
    return dp[m][n];
}