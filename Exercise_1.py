# Time Complexity : O(amount * n), where n is the number of coin types.
# Space Complexity : O(amount)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I had to initialize unreachable amounts clearly so they do not look like valid answers.
# Approach: I used a one-dimensional DP array where dp[i] stores the fewest coins needed for amount i.
# For each amount, I tried every coin that can fit and used the best previously solved amount.
# If the final amount is still unreachable, I returned -1.


class Solution:

    def coinChange(self, coins, amount):
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0

        for current_amount in range(1, amount + 1):
            for coin in coins:
                if coin <= current_amount:
                    dp[current_amount] = min(
                        dp[current_amount],
                        dp[current_amount - coin] + 1
                    )

        if dp[amount] == amount + 1:
            return -1

        return dp[amount]
