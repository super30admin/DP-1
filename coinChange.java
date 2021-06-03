// m: number of coins; n: amount
// Time Complexity:  O(m x n)
// Space Complexity: O(m x n)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] matrix = new int[coins.length+1][amount+1];
        
        for(int i=0; i<matrix.length; i++){
            matrix[i][0] = 0;
        }
        
        for(int j=1; j<matrix[0].length; j++){
            matrix[0][j] = amount+1;
        }
        
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(j < coins[i-1]){
                    matrix[i][j] = matrix[i-1][j];
                }else {
                matrix[i][j] = Math.min(matrix[i-1][j], 1 + matrix[i][j-coins[i-1]]);
                }
            }
        }
        
        return matrix[coins.length][amount] > amount ? -1 : matrix[coins.length][amount];
    }
}