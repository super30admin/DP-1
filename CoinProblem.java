// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0) return 0;
        int[][] matrix = new int[coins.length+1][amount+1];
        matrix[0][0]=0;
        for(int i= 0;i<amount+1;i++){
            matrix[0][i] = amount+1;
        }
        
        for(int i= 1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                if( j < coins[i-1])
                    matrix[i][j] = matrix[i-1][j];
                else
                    matrix[i][j] = Math.min(matrix[i-1][j],matrix[i][j-coins[i-1]]+1);
            }
        }
        int result= matrix[coins.length][amount];
        if(result>amount)
            return -1;
        return result;
    }
}
