"""
Approach: Try all possible ways to get the most min number of coins used. 2 choices - either use
current coin or do not. If used then can use it again.
"""
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)
        m = amount + 1
        dp = [[-1 for i in range(m)] for j in range(n)]
        def recurse(index, amount):
            if amount == 0:
                return 0

            if index == 0:
                if (amount%coins[index]) == 0:
                    return amount//coins[index]
                return float("inf")
            if dp[index][amount] != -1:
                return dp[index][amount]

            if amount < coins[index]:
                dp[index][amount] = recurse(index - 1, amount)
            else:
                dp[index][amount] = min(recurse(index - 1, amount), 1 + recurse(index, amount - coins[index]))
            return dp[index][amount]
        ret = recurse(len(coins) - 1, amount)
        if ret == float("inf"):
            return -1
        return ret