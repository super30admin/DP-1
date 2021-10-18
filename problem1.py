# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: ✔️
# Any problem you faced while coding this: Not sure if this is the most efficient solution
from typing import List


class Solution:
    def coin_change(self, coins: List[int], amount: int) -> int:
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0

        for coin in coins:
            for x in range(coin, amount + 1):
                dp[x] = min(dp[x], dp[x - coin] + 1)
        return dp[amount] if dp[amount] != float('inf') else -1