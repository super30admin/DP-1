# Time Complexity: O(coins * amount)
# Space Complexity: O(amount)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

from ast import List


class CoinChange:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins == None or len(coins) == 0:
            return 0

        dp = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]

        for i in range(len(dp)):
            dp[i][0] = 0

        for j in range(1, len(dp[0])):
            dp[0][j] = amount + 1

        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min((dp[i - 1][j]), (1 + dp[i][j - coins[i - 1]]))

        result = dp[len(dp) - 1][len(dp[0]) - 1]

        if result > amount:
            return -1
        else:
            return result