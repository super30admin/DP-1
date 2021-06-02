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
}
