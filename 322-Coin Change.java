//Time complexity=O(N*M), M =Amount, N = size of coins array
//Space complexity=O(N*M), M =Amount, N = size of coins array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

//Here we are creating a matrix to store the minimum combination for all the values upto the amount and returning the last value of the matrix as it is the minimum combination of  coin possible to make the amount using all the given coins.
//In the matrix to find the values of indices, we have two conditions where, if the amount is less than coin value then we are just taking the value of row(i.e coins required to make the amount using previous coin), or else we are taking the minimum value from it previous, and the also value of the (current amount - value of current coin), and from the amount obtained we are checking its combination in the same coin and adding it by 1. 
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length+1][amount+1];
        for(int i=0;i<=amount;i++)
            dp[0][i]=99999;
        for(int i=0;i<=coins.length;i++)
        {
            dp[i][0]=0;
        }
        
        
        for(int i=1;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if( j < coins[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
       int minNumCoins = dp[coins.length][amount];
        if(minNumCoins >= 99999)  return -1;
        else return minNumCoins;
    }
}