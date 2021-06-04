// Time Complexity : O(n^2)), 
// Space Complexity : O(n), where n is size of matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package dp1;

public class CoinChange {

    public int coinChangeMat(int[] coins, int amount) {
        //check length
        if (coins.length == 0 || coins == null) {
            return 0;
        }
        int[][] matrix = new int[coins.length + 1][amount + 1];
        //filling the first column to zero 
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
        //filling the first row to amount
        for (int j = 1; j < matrix[0].length; j++) {
            matrix[0][j] = amount + 1;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                //when amount is less than denomination coin used
                if (j < coins[i - 1]) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    //take minimum
                    matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i][j - coins[i - 1]] + 1);
                }
            }
        }
        //take the last index as result and compare
        int result = matrix[matrix.length - 1][matrix[0].length - 1];
        if (result > amount) {
            return -1;
        }
        return result;
    }

}
