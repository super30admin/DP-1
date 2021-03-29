# Time Complexity : O(nm), where n is the number of coins and m is the amount
# Space Complexity : O(nm)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]

        for j in range(1, len(dp[0])):
            dp[0][j] = amount + 1

        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if (j < coins[i - 1]):
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1)

        return -1 if dp[-1][-1] == amount + 1 else dp[-1][-1]
