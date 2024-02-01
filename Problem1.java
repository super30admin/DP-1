// Time Complexity :  O(mn) m = amount; n = number of coins
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Your code here along with comments explaining your approach
 * Started with exhaustive approach by either taking an element or not
 * This lead to some repeated calculations which could be optimized by tabulation
 * For tabulation, we compute all solutions for a single coin; as this helps to compute
 * all solutions for this coin + the next coin and so on.
*/

class Problem1 {
    int MAX_VALUE = 10001;

    public int coinChange(int[] coins, int amount) {
        // null case
        if (coins == null || coins.length == 0)
            return 0;
        int[][] matrix = new int[coins.length][amount + 1];

        // filling first row of the matrix
        for (int i = 0; i < matrix[0].length; i++) {
            // with a single coin; you can only make the target if target is divisble by
            // coin value
            if (i % coins[0] == 0) {
                matrix[0][i] = i / coins[0];
            } else {
                matrix[0][i] = MAX_VALUE;
            }
        }

        // now we have the first row; with first row you can make second;
        // with first and second, you can make third and so on.
        // making the tree in the matrix
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j < coins[i]) {
                    matrix[i][j] = matrix[i - 1][j];
                    continue;
                }
                matrix[i][j] = Math.min(matrix[i - 1][j], 1 + matrix[i][j - coins[i]]);
            }
        }

        // no valid path
        if (matrix[coins.length - 1][amount] == MAX_VALUE) {
            return -1;
        }

        return matrix[coins.length - 1][amount];
    }
}