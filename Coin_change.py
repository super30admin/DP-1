#Time Complexity = O(N * amount)
# Space Complexity = O(N * amount)
#
# Yes it ran on Leetcode.

class Solution(object):
    def coinChange(self, coins, amount):

        dp = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]
        for i in range(len(coins) + 1):
            dp[i][0] = 0
        for j in range(1, amount + 1):
            dp[0][j] = amount + 1

        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1)

        res = dp[len(coins)][amount]

        if res > amount:
            return -1
        else:
            return res