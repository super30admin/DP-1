#TC : O(mn)
#SC : O(mn)

class Solution:
    def coinChange(self, coins, amount: int):

        if not coins:
            return 0
        
        m, n = len(coins), amount
        dp = [[n+1 for i in range(n+1)] for j in range(m+1)]

        for i in range(m+1):
            dp[i][0] = 0
        
        for i in range(1, m+1):
            for j in range(1, n+1):
                if j < coins[i-1]:
                    dp[i][j]= dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j-coins[i-1]])

        if dp[m][n] == n+1:
            return -1
        return dp[m][n]
