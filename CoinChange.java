class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length + 1; // number of available denominations
        int m = amount + 1; //denomination of amount need to ne achieved
        
        //creating an array of size m by n
        int[][] dp = new int[n][m];
        
        //intitalizing the first row from column 1 to end to max value
        for(int j =1; j<m; j++){
            dp[0][j] = 9999;
        }
        
        //iterate through the matrix to find the optimal solution
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(j < coins[i -1]){ // if the cloumn denomination is less than the coin value of row then just substitute with the previous row values
                    dp[i][j] = dp[i-1][j];
                }else{
                    //else find the min of coins when you chose and dont chose the coin
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][ j - coins[i-1]]);
                }
            }
        }
        
        // if the final solution is max value return -1
        //else return  the optimal solution obtained
        return dp[n-1][m-1] == 9999 ? - 1: dp[n-1][m-1];
    }
}

// Time Complexity: O(nm)
// Space Complxity: O(nm)