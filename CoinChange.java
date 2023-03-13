public class CoinChange {

// Time Complexity : O(mn) where m is coins length(rows) and n is amount(columns) in matrix
// Space Complexity : O(mn) 2D matrix
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :  No

    public int coinChange(int[] coins, int amount) {
        int m=coins.length;
        int n=amount;
        int[][] arr = new int[m+1][n+1];
        arr[0][0] = 0;
        for(int i=1;i<=n;i++){
            arr[0][i] = 99999;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++) {
                if(j < coins[i-1]) {
                    arr[i][j] = arr[i-1][j];
                } else {
                    arr[i][j] = Math.min(arr[i-1][j], 1+arr[i][j- coins[i-1]]);
                }
            }
        }
        if(arr[m][n]>=99999) return -1;
        return arr[m][n];
    }
}
