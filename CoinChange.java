
/*
* Approach:
*  1. This cannot be solved in greedy, as local max coin doesnt give us the answer.
*       Therefore, we have to check all the possibilites through recursion.
*  2. Recurrence Relation: 
        coinChange(amount) = min{
                                coinChange(amount-coin(i)),                        
                                coinChange(amount-coin(j)),
                                coinChange(amount-coin(k)),.......
                            }
*     Base condition: 
            if amount is 0, we dont require any coins.
            if amount is less than 0, that means it cannot lead to solution,
                    because negative denominations are not possible.
*  3. As, we are having overlapping subproblems, 
        we can apply DP using 1d array.
*       
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(amount * coins)
* 
* Space Complexity: O(amount) + O(coins) == O(amount)
                    1d DP array size + call stack size
* 
*/
import java.util.Arrays;

public class CoinChange {
    private int coinChange(int[] coins, int amount, int[] dp) {
        if (amount == 0)
            return 0;

        if (amount < 0)
            return Integer.MAX_VALUE;

        if (dp[amount] != -1)
            return dp[amount];

        dp[amount] = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = coinChange(coins, amount - coin, dp);

            if (res != Integer.MAX_VALUE)
                dp[amount] = Integer.min(dp[amount], 1 + res);
        }

        return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, -1);

        int result = coinChange(coins, amount, dp);

        if (result == Integer.MAX_VALUE)
            return -1;

        return result;
    }
}
