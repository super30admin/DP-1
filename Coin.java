// Time Complexity :O(nm) where n is the size of the coin array and m is the amount.
// Space Complexity :O(nm) since the 2d array will increase in size if the amount or the coin array length increases.
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach


class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length ==0) return -1;
        int[][] matrix = new int[coins.length+1][amount+1];
        for(int i=0;i<matrix.length;i++)
        {
            matrix[i][0] = 0;
        }
        for(int i=0;i<matrix[0].length;i++)
        {
            matrix[0][i] = 9999;
        }
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(j<coins[i-1])
                {
                    matrix[i][j] = matrix[i-1][j]; 
                }
                else
                {
                    matrix[i][j]= Math.min(matrix[i-1][j], matrix[i][j -coins[i -1]]+1);
                }
            }

        }
        
        int result = matrix[matrix.length-1][matrix[0].length-1];
        if (result>=9999) return -1;
        else return result;
            
    }
}