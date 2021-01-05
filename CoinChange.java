// Time Complexity : O((coins.length) * (amount))
// Space Complexity : O((coins.length) * (amount))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Difficulty in figuring out how to populate the matrix

// Notes : Brute force solution involves creating a tree which either accepts or rejects the coin in calculating the total amount, iteratively. Optimised solution includes fitting this tree into a matrix, where the current cell is populated by calculating the minimum, if the current coin is rejected or if it is accepted. The maximum number of coins used will be the bottom leftmost cell of the matrix. 

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        
        int[][] matrix = new int[coins.length + 1][amount+1];

        for( int i = 1; i< matrix[0].length; i++){
            matrix[0][i] = 99999;
        }
        
        for(int i = 1; i< matrix.length; i++){
            for(int j = 1; j< matrix[0].length; j++){
                if(j < coins[i - 1]){
                    matrix[i][j] = matrix[i-1][j];
                } else {
                    matrix[i][j] = Math.min(matrix[i-1][j], 1+ matrix[i][j - coins[i - 1]]);
                }
            }
        }
        
        if(matrix[matrix.length - 1][matrix[0].length - 1] > amount){
            return -1;
        }
        
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }
}
