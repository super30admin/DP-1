//Bottom Up DP Solution
class Solution {
    public int coinChange(int[] coins, int amount) {
        //Tc: O(m*n)  Sc: O(m*n)
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        for(int j = 1; j < dp[0].length ; j++)
        {
            dp[0][j] = 99999;
        }
        //Arrays.fill(dp[0], 1, dp[0].length, 99999);

        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 1; j < dp[0].length; j++)
            {
                if(j < coins[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }

        if(dp[m][n] >= 99999) return -1;
        return dp[m][n];
    
    }
}

//Exhaustive Approach solution
        /*
        return helper(coins, 0, amount, 0);
        
    }
     public int helper(int[] coins, int index, int amount, int minCoins)
    {
        if(amount == 0) return minCoins;
        if(amount < 0 || index == coins.length) return -1;

        //If I choose the coin at ith index
        int case1 = helper(coins, index, amount - coins[index], minCoins+1);
        //If I do not choose the coin at ith index
        int case2 = helper(coins, index+1, amount, minCoins);

        //Check if any of the cases give a null solution

        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        return Math.min(case1, case2);
        */
