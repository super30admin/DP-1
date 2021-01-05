// Time Complexity : O(mn)  (m = no of coins & n = amount)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int coinChange(int[] coins, int amount) {

        if(coins == null || coins.length == 0 ) return -1;

        int rows = coins.length  + 1;
        int cols = amount + 1;

        int[][] dpMatrix = new int[rows][cols];

        dpMatrix[0][0] = 0;
        for(int i = 1; i < cols; i++) {
            dpMatrix[0][i] = amount + 2;
        }

        for (int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(coins[i-1] > j) {
                    dpMatrix[i][j] = dpMatrix[i-1][j];
                }
                else {
                    int case1 = dpMatrix[i-1][j];
                    int case2 = dpMatrix[i][j-coins[i-1]] + 1;
                    dpMatrix[i][j] = Math.min(case1,case2);
                }
            }
        }

        if(dpMatrix[rows-1][cols-1] == amount + 2)
            return -1;
        return dpMatrix[rows-1][cols-1];
    }
}
