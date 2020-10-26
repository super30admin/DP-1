// Time Complexity : O(n*m) where n is no. of coins and m is amount
// Space Complexity : O(n*m) where n is no. of coins and m is amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Approach
 * We will be using the DP approach and building the tabular matrix with rows as coins and columns corresponding to amount from 0 to amount
 * At each position i,j we will have minimum coins until ith index to reach jth amount
 * Matrix will have min coins required to reach the amount.
 * */

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0) return -1;

        int m = coins.length+1;
        int n = amount+1;

        int [][] mat = new int[m][n];
        //this is value for infinity
        int max = 999999;

        //fill in the 1st row with infinity except 0,0 position
        for(int j=1;j<n;j++){
            mat[0][j] = max;
        }

        for(int i=1; i<m; i++){
            for(int j = 1; j<n; j++){
                //if the amount is less than the coin value
                if(j<coins[i-1]){
                    mat[i][j] = mat[i-1][j];
                }
                else {
                    //check the minimum value between previous row or same row - coin value
                    mat[i][j] = Math.min(mat[i-1][j], mat[i][j-coins[i-1]]+1);
                }
            }
        }
        //check if the value is infinity
        return mat[m-1][n-1]>=max ?  -1 : mat[m-1][n-1];
    }
}