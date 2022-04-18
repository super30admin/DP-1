class Solution:
    def coinChange(self, coins: list[int], amount: int) -> int:
        dp = [amount + 1] * (amount+1)  # because we are going to amount from 0
        dp[0] = 0

        for a in range(1, amount+1):
            for c in coins:
                if a-c >= 0:
                    dp[a] = min(dp[a], 1+dp[a-c])

        # if the stored the value is not the default value
        return dp[amount]if dp[amount] != amount+1 else-1

        # time O(amount * len(coins)) or O(S*n)
        # memory O(amount) or O(S)
        # YEs the problem is running on the leetcode.
        # Problem faced was in understanding the Dynamic Programming Logic.
