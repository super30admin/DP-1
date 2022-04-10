// Time Complexity : O(M * N) where M = length of coins array and N = amount
// Space Complexity : O(M * N) since we are using DP array of  M*N entries
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach

/*

Since this is extensive approach DP is used. 
The first row of DP matrix is filled with infinity since having 0 coins and 
amount to make is  impossible.

Till we approach a sum that is equal to the coin[i], we fill with the above value 

The current dp[i][j] is equal to the min value of the above and the value subtracted with coin +1.

*/


public class CoinChange {
    
    public static int coinChange(int[] coins, int amount)
    {
        if(coins == null || coins.length == 0)
        {
            return 0;
        }

        int[][] dp = new int[coins.length+1][amount+1];
        
        //1st row
        for(int i = 0;i<dp[0].length;i++)
        {
            dp[0][i]=Integer.MAX_VALUE;
        }

        //1st column
        for(int i = 1;i<dp.length;i++)
        {
            dp[i][0]=0;
        }


        //rest of all DP

        for(int i = 1;i<dp.length;i++)
        {
            for(int j = 1;j<dp[0].length;j++)
            {
                if(j<coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]= Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }

        if(dp[coins.length][amount]== amount + 1)
        {
            return -1;
        }
        return dp[coins.length][amount];


    }

    public static void main(String args[])
    {
        int[] coins = {1,2,5};
        int amount = 11;

        System.out.println(coinChange(coins, amount));
    }

}
