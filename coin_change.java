//Time and Space: O(m*n)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] arr = new int[m + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            arr[0][i] = Integer.MAX_VALUE - 10;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < coins[i - 1]) {
                    arr[i][j] = arr[i - 1][j];
                } else {
                    arr[i][j] = Math.min(arr[i - 1][j], 1 + arr[i][j - coins[i - 1]]);
                }
            }
        }
        
        if (arr[m][n] >= Integer.MAX_VALUE - 10) {
            return -1;
        } else {
            return arr[m][n];
        }
    }
}
