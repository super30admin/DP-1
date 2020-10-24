// Time Complexity : O(n+m), where m is the size of coins array and n is the amount (as we are iterating over the entire grid to fill out)
// Space Complexity : O(n+m), where m is the size of coins array and n is the amount (space required for the grid of size [m+1][n+1])
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Want to confirm if my thinking is right about the time and space complexity

// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        //if coins array is null or empty return -1
        if( coins == null || coins.length ==0) return -1;
        
        int m = coins.length;
        int n =  amount;
        //+1 because we are adding an additional row and column
        int [][]dp = new int[m+1][n+1];
        //assigning maximum value to the first row, except the first index
        for(int j=1; j<=n; j++){
            dp[0][j] = 9999;
        }
        
        //fill out the rest of the grid
        for(int i =1; i<= m ; i++){
            for(int j =1; j<= n; j++){
                //if j (column index) is less than the current coin
                if(j < coins[i-1]){
                    //at the cuurent index, copy the value of its above index
                    //meaning, the current coin cannot be used to make the current amount
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    //in the same row, take the minimum of the value at its above index(that is not selecting the current coin) and the index that is current coin times behind the current index (that is selecting this coin)
                    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j-coins[i-1]]);
                }
            }
        }
        //the last cell of the grid will have the minimum coins needed
        //if the last cell is infinity, meaning, the amount cannot be made with the given coins, so return -1
        int result = dp[m][n];
        if(result >= 9999){
            return -1;
        }
        //return the value at the last cell, representing the minimum coins
        return dp[m][n];
    }
}