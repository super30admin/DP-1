// Time Complexity : O(n * amount), where n is the number of coins
// Space Complexity : O(n * amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Recursion caused TLE because it was repeatedly solving 
                                            //subproblems that had already been computed.

// Approach:
// Fill the first row. If an amount is a multiple of the first coin, store the count
            //otherwise, store (100001).
// For each subsequent row i.e next coin, check if the coin can be used. 
//         If it can be used, choose the minimum between not using the coin and using it.
//  If the final answer is still 100001, return -1
//  Otherwise, return the minimum number of coins needed.



class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        int[][] twoD = new int[coins.length][amount+1];
        for(int i=0;i<twoD.length;i++)
        {
            if(i==0)
            {
                for(int j=1;j<amount+1;j++)
                {
                    if(j%coins[i]==0)
                    {
                        int add = j/coins[i];
                        twoD[i][j] = add;
                    }
                    else
                    {
                        twoD[i][j] = 100001;
                    }
                }
            }
            else
            {
                for(int j=1;j<amount+1;j++)
                {
                    if(j<coins[i])
                    {
                        int add = twoD[i-1][j];
                        twoD[i][j] = add;
                    }
                    else
                    {
                        int add = Math.min(twoD[i-1][j],(twoD[i][j-coins[i]]+1));
                        twoD[i][j] = add;

                    }
                }
            }
        }
        if(twoD[coins.length-1][amount]==100001)
        {
            return -1;
        }
        return twoD[coins.length-1][amount];
    }
}