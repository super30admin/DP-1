# Time Complexity : coinChange and coinChange_n2 : O(n^2)
# Space Complexity : coinChange: O(n) and coinChange_n2: O(n^2)
# Did this code successfully run on Leetcode : Yes solved the question
# Any problem you faced while coding this : No

class Solution:

    def coinChange(self, coins, amount):
        n = len(coins)
        m = amount
        dp = [m + 1 for each in range(m + 1)]
        dp[0] = 0

        for i in range(1, 1 + n):
            for j in range(1, 1 + m):
                if coins[i - 1] <= j:
                    dp[j] = min(dp[j], 1 + dp[j - coins[i - 1]])
        res = dp[m]
        if res >= m + 1:
            return -1
        return res


    def coinChange_n2(self, coins, amount):
        n = len(coins)
        m = amount
        dp = [[0 for each in range(m + 1)] for every in range(n + 1)]

        for j in range(1, 1 + m):
            dp[0][j] = amount + 1
        
        for i in range(1, 1 + n):
            for j in range(1, 1 + m):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min( dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])
        
        res = dp[n][m]
        if res >= amount + 1:
            return -1

        return res

s = Solution()
coins = [1,2,5]
amount = 11
print(s.coinChange(coins, amount))
coins = [2]
amount = 3
print(s.coinChange(coins, amount))
coins = [1]
amount = 0
print(s.coinChange(coins, amount))
