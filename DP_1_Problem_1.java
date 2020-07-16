//Brute force
//Time Complexity : O(2^(m+n))
//Space Complexity : Just the stack space
// Run succesfully on leetcode (Time exceeded)
// Problems :  No problem

//Optimized DP
//Time Complexity : O(m*n)
//Space Complexity: O(m*n)
//Run successfully on leetcode
//Problem : Analyzing the pattern




public class DP_1_Problem_1 {
    public int coinChangez(int[] coins, int amount) {
        if(coins == null || coins.length==0) return -1;

        return helper(coins,0,amount,0);

    }
    private int helper(int[] coins,int index,int amount,int count)
    {
        if(amount==0) return count;
        if(index>=coins.length || amount<0)
        {
            return -1;
        }
        int case1 = helper(coins,index+1,amount,count);
        int case2 = helper(coins,index,amount-coins[index],count+1);
        return Math.min(case1,case2);
    }

    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length==0) return -1;

        int[][] matrix = new int[coins.length+1][amount+1];
        for(int i = 1; i < matrix[0].length; i++)
        {
            matrix[0][i] = 9999;
        }
        for(int i = 1 ; i< matrix.length;i++)
        {
            for(int j = 1 ; j < matrix[0].length;j++)
            {
                if(j<coins[i-1])
                {
                    matrix[i][j]=matrix[i-1][j];
                }
                else
                {
                    matrix[i][j] = Math.min(matrix[i-1][j],matrix[0][j-coins[i-1]]+1);
                }
            }
        }
        return matrix[matrix.length-1][matrix[0].length-1];

    }


}
