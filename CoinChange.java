package com.ds.rani.dp;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * Input: coins = [2], amount = 3 Output: -1 Note: You may assume that you have an infinite number of each kind of coin.
 */

//Time Complexity: O(n*k) where n is the amount and k is given coin denominations.
//Space Complexity: O(n) where n is the given amount. As we are creating array of size n.
public class CoinChange {
    /**
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int minCoinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=0; i<amount+1; i++)
        {
            for(int j=0; j<coins.length; j++)
            {
                if(coins[j] <= i)
                {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        if(dp[amount] > amount)
        {
            return -1;
        }
        else
        {
            return(dp[amount]);
        }

    }

    public static void main(String[] args) {
    int coins[]={1, 2, 5};
        System.out.println(CoinChange.minCoinChange(coins,11  ));
    }
}
