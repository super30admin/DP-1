// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Coin change problem, find fewest number of coins to make target amount
class Solution {
    public int coinChange(int[] coins, int amount) {

        int m = amount;
        int n = coins.length;
        int[][] matrix = new int[n+1][m+1];

        for (int i =1; i<=m; i++){
            matrix[0][i] = 999999;
        }

        for(int i =1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(j < coins[i-1]) {
                    //when amount is smaller than the denomination
                    matrix[i][j] = matrix[i-1][j];
                }
                else{
                    matrix[i][j] = Math.min(matrix[i-1][j], 1+ matrix[i][j-coins[i-1]]);
                }
            }
        }

        if(matrix[n][m] >= 999999) return -1;
        return matrix[n][m];
        
    }
}