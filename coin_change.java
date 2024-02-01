class Solution {
    public int coinChange(int[] coins, int amount) {
        int row=coins.length;
        int col=amount;
        int [][] matrix=new int [row+1][col+1];
        matrix[0][0]=0;
        for(int j=1;j<=col;j++)
        matrix[0][j]=99999;
        for(int i=1;i<=row;i++)
        {
            for(int j=1;j<=col;j++)
            {
                if(j<coins[i-1])
                {
                   matrix[i][j]=matrix[i-1][j]; 
                }
                else
                {
                    matrix[i][j]=Math.min(matrix[i-1][j],1+matrix[i][j-coins[i-1]]);
                }
            }
        }
        if(matrix[row][col]>=99999)
        return -1;
        return matrix[row][col];
    }
}
