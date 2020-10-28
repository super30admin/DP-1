// Time Complexity :O(m*n) m= amount, n= coins
// Space Complexity : O(m*n) m= amount, n= coins
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Use DP, create a metrix fill first row with infinity values,
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;

        int m = coins.length + 1;
        int n = amount + 1;

        int[][] matrix = new int[m][n];
        //Set infinity
        int max = 999999;

        //fill in the 1st row with infinity except 0,0 position
        for (int j = 1; j < n; j++) {
            matrix[0][j] = max;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (j < coins[i - 1]) {
                    //if the amount is less than the coin value take value from above
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    //check the minimum value between above row or same row - coin value steps back
                    matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i][j - coins[i - 1]] + 1);
                }
            }
        }
        //return last row last column, if it's freater than set infinity return -1
        return matrix[m - 1][n - 1] >= max ? -1 : matrix[m - 1][n - 1];
    }
}