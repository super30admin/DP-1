
// Time Complexity :O(m * n)
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] data = new int[m+1][n+1];
        data[0][0] = 0 ;  

        for( int j=1; j<=n; j++ )
         data[0][j] = Integer.MAX_VALUE - 10;


        for(int i=1; i <=m ; i++ ){
            for(int j=1;j<=n; j++){

               if(j < coins[i-1]){
                    data[i][j] = data[i-1][j];
                }

                else {
                    data[i][j] = Math.min(data[i-1][j], 1 + data[i][j - coins[i-1]] );
                }

            }


        }
        if(data[m][n] >= Integer.MAX_VALUE - 10) return -1;
        return data[m][n];




    }
}
