import java.util.Arrays;


//TC : O(A*n) where n is the denominations of the coins given and A is the amount.
//SC : O(A) : to store the answer for all the subproblems
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//We take a bottom-up approach where to calculate the answer for any value k,
// we use the answers from all the values k-coins[i].
//We use an array dp of lenth amount+1 to store these values. The value at any index j is the min no of coins needed for amount = j.

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        //initialize with amount +1 as that can never be the min no of coins
        Arrays.fill(dp,  amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++)
        {
            for (int j = 0; j < coins.length; j++)
            {
                if (coins[j] <= i)
                {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChange_approachTwo(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount+1]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem] != 0) return count[rem];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem ] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem ];
    }

    public int coinChange_approachThree(int[] coins, int amount)
    {

       if(coins == null || coins.length == 0)
           return 0;
       return helper(coins, amount, 0,0);

    }

    private int helper(int[] coins, int amount, int index, int min)
    {

        //basecase
        if(amount ==0)
            return min;

        if(index == coins.length || amount < 0)
            return -1;

        //choose the current coin
        int case1 = helper(coins, amount-coins[index],index,min+1);

        //skip the current coin
        int case2 = helper(coins, amount,index+1,min);

        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        return Math.min(case1, case2);

    }

    public int coinChange_approach_four(int[] coins, int amount) {

        if(coins == null || coins.length == 0)
            return 0;

        int[][] dp = new int[coins.length+1][amount+1];

        for(int i=0; i<dp.length; i++)
            dp[i][0] = 0;

        for(int i=0; i<dp[0].length;i++)
            dp[0][i] = amount+1;

        for(int i=1; i <dp.length; i++)
        {
            for(int j =1; j<dp[0].length; j++)
            {
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
            }
        }

        return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];

    }
}
