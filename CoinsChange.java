// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : got the integer overflow for default infinity value as Integer.MAX_VALUE
// Your code here along with comments explaining your approach


class CoinsChange {
    public int coinChange(int[] coins, int amount) {
        int rows = coins.length+1;
        int cols = amount+1;
        int[][] compMtrx = new int[rows][cols];
        for(int i = 1; i < cols; i++){
            compMtrx[0][i] = 99999;
        }
        for(int i = 0; i < rows; i++){
            compMtrx[i][0] = 0;
        }
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if(j < coins[i-1]){
                    compMtrx[i][j] = compMtrx[i-1][j];
                }else{
                    compMtrx[i][j] = Math.min((compMtrx[i-1][j]), (1+ compMtrx[i][j-coins[i-1]]));
                }
            }
        }
        return compMtrx[rows-1][cols-1] == 99999 ? -1 : compMtrx[rows-1][cols-1];
    }
}
