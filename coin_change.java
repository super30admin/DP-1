// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, Overlapping sub problem was clear, but optimal sub-structure took time to understand


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        int rows = coins.length+1; // No of coins+1(0 included)
        int columns = amount+1;// From 0 to amount
        
        int dp[][] = new int[rows][columns];//dp matrix
        
        for(int i=1;i<columns;i++){
            dp[0][i] = 9999;// Leetcode constraint, can't be greater than 10000
        }
        
        for(int j=0;j<rows;j++){
            dp[j][0] = 0;//Initial column is zero because, we can't reach 0 using any coin denominations
        }
        
        for(int i=1;i<rows;i++){
            for(int j=1;j<columns;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];// At any point, if amount is less than coin denomination, we return DC option , which is above row value for the same point
                }
                else{
                  //Min of chose and don't chose, choose would be going i steps back and getting the coins value from array in the same row, 1 is added as i is already selected
                    dp[i][j] = Math.min(dp[i-1][j], 1+(dp[i][j-coins[i-1]]));
                }
            }
        }
        
      //If at all, there is 9999, then we can say that answer is -1;
        return dp[rows-1][columns-1]==9999? -1:dp[rows-1][columns-1];
    }
}
