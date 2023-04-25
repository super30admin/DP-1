## Problem1 (https://leetcode.com/problems/coin-change/)

# Time Complexity : O(n*m)
# Space Complexity : O(n*m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def coinChange(coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
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

    coins = [1, 2, 5]
    amount = 11
    print(coinChange(coins, amount))