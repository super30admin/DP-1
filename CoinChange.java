// Time Complexity :o(n * m) , where n is the number of coins and m is the target
// Space Complexity :o(n * m) , where n is the number of coins and m is the target
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Here we are using a 2-d matrix of size n*m where n is the number of different coins and m is the target. For each value starting from 0 to target and
//for each denomination , we store the minimum number of denominations required for to get that value. This way we maintain the history and
//in the end for the target we get the most optimal solutions.
class Solution {
    public int coinChange(int[] coins, int amount) {
    
        int n = coins.length +1;
        int m = amount + 1;
        
        int[][] matrix = new int [n][m];
        
        //initialising the columns with the maximum value allowed
        for(int i=1;i<m;i++)
        {
            matrix[0][i] = 99999;
        }
        //initialising the rows with 0
        for(int i =0;i<n;i++)
        {
            matrix[i][0]=0;
        }
        //storing the optimal solutions in rest of the cells of the 2-d matrix
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
            	//if the target is less than the max value of coin, get the old optimal solutions
                if(j<coins[i-1])
                {
                    matrix[i][j] = matrix[i-1][j];
                }
                //getting the minimum from the previous optimal solutions and from current coins
                else
                {
                    matrix[i][j] = Math.min(matrix[i-1][j],1+matrix[i][j-coins[i-1]]);
                }
            }
        }
        //return -1 if the value can not be made up by any coins else return the most optimal solution from the right-bottom most element of the array
        return matrix[n-1][m-1] == 99999 ? -1 :matrix[n-1][m-1];
        
    }
}