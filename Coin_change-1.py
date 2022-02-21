"""
Time Complexity :- O(2^amount/min_denomination)
Space Complexity :- O(amount *n)
"""

import sys


class Solution:
    def coinChange(self, coins, amount) -> int:
        dp = [[0] * (amount + 1) for i in range(len(coins))]
        ans = self.coinChange1(coins, 0, amount, dp)
        if ans == sys.maxsize:
            return -1
        else:
            return ans

    def coinChange1(self, coins, index, amount, dp):
        if amount == 0:
            return 0

        if amount < 0 or index == len(coins):
            return sys.maxsize

        if dp[index][amount] > 0:
            return dp[index][amount]

        nchoserans = self.coinChange1(coins, index + 1, amount, dp)

        chooseans = self.coinChange1(coins, index, amount - coins[index], dp)

        if chooseans != sys.maxsize:
            chooseans += 1

        dp[index][amount] = min(chooseans, nchoserans)

        return dp[index][amount]