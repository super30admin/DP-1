"""
TC: O(N*M) {here N is the len of coins and M is the amount}
SC: O(M) {here we only store the 1D array of length of the amount (x-axis)}

Approach:

We used a tabulation Dynamic problem solution. Where we first create a 1D array of len of the amount, since we want to iterate 
for every amount till the given amount.

We then use the same 0/1 choosing, where we either choose the denomination or skip and move to the next one. Every time we choose the
denomination, we add 1 to our number of ways for that sub problem.

The 1D array plays a crucial role, it helps in eliminating the calculation of repeated sub-problems.

Finally we get the min combination at the last idx of our list.

This problem ran successfully on Leetcode.
"""

from typing import List
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        m = amount+1
        dp = [float("inf")] * m
        dp[0] = 0

        for coin in coins:
            for j in range(coin, m):
                dp[j] = min(dp[j], 1 + dp[j-coin])

        return dp[-1] if dp[-1] < float("inf") else -1