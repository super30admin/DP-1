#Time Complexity: O(m*n)
#Space Complexity: O(m*n)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins == None or len(coins) == 0:
            return -1

        n = amount
        m = len(coins)
        dp = [[0] * (n+1) for _ in range(m+1)]

        for i in range(1, n+1):
            dp[0][i] = float('inf')

        for i in range(1, m+1):
            for j in range(1, n+1):
                if j >= coins[i-1]:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])
                else:
                    dp[i][j] = dp[i-1][j]
        
        if dp[m][n] == float('inf'):
            return -1
        
        return dp[m][n]