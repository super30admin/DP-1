'''
Time Complexity - O(mn) where is number of coins and n is the amount
Space Complexity = O(mn) used to store the matrix of size m*n
'''


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins)
        n = amount
        dp = [[0 for x in range(n+1)] for y in range(m+1)]
        dp[0][0] = 0
        for j in range(len(dp[0])):
            dp[0][j] = amount+1
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]])
        if dp[m][n] > amount:
            return -1
        return dp[m][n]
