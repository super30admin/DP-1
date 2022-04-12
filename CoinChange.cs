// Time Complexity : O(m*n) m is the amount, n is the coins length
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, debugged and found issue


// Your code here along with comments explaining your approach
//https://leetcode.com/problems/coin-change/

public int CoinChange(int[] coins, int amount) {
        
        if(coins == null || coins.Length == 0)
            return 0;

        int[,] dp = new int[coins.Length + 1, amount + 1];

        //run loop on dp column or maount ro set first row to inifinity value
        for(int j = 1; j < dp.GetLength(1); j++)
        {
            //we set all 0 row wiht max value, int32 max value or amount+1 in our case.
            dp[0, j] = amount + 1;
        }

        for(int i = 1 ; i < dp.GetLength(0); i++)
        {
            for(int j = 1; j < dp.GetLength(1); j++)
            {
                //if current amount is less than current coins value
                //we can simply take previous (or above) value and set it.
                if(j < coins[i-1])
                    dp[i,j] = dp[i-1,j];
                else
                //otherwise take min of following
                // value above row and current column or
                //value at current row, amount(column) - coin value(current row) + 1 (coin is used)
                    dp[i,j] = Math.Min(dp[i-1,j], dp[i, j - coins[i-1] + 1]);

            }
        }

        //here amount+1 is infinity, so if last value is amount +1, it means no solution, return -1
        if(dp[coins.Length, amount] == amount + 1)
            return -1;

        //othersie return last element inmatrix
        return dp[coins.Length, amount];
    }
