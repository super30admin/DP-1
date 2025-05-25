# Time and space complexity - o(m*n)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)
        m = amount
        
        dp = [[float('inf')-10] * (m + 1) for _ in range(n + 1)] 

        
        for i in range(n + 1):
            dp[i][0] = 0
            
        for i in range(1,n+1):
            for j in range(1,m+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j],1+dp[i][j-coins[i-1]])

        return -1 if dp[n][m]==float('inf')-10 else dp[n][m]

        

