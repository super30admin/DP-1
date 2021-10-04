#Time Complexity = O(m*n)
#Space Complexity = O(m*n)
#Successfully compiled and run on Leetcode


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins) + 1 #rows
        m = amount + 1 #cols

        dp = [[0 for i in range(m)] for j in range(n)]  #initializing 2d matrix

        for j in range(1, m): #initializing 1st row and 1st col
            dp[0][j] = 99999
        for i in range(0, n):
            dp[i][0] = 0

        for i in range(1, n):
            for j in range(1, m):
                if (j < coins[i - 1]): #if amount is less than the denomination
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]) # else dp logic

        return -1 if dp[n - 1][m - 1] == 99999 else dp[n - 1][m - 1]