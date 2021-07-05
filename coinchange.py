# Runs on Leetcode
# time complexity - O(a*b)                    a - number of coins
# Memory complexity - O(a*b)                  b - range of amount


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[None for i in range(amount + 1)] for j in range(len(coins) + 1)]
        
        rows = len(dp)
        cols = len(dp[0])
        
        for i in range(cols):
            dp[0][i] = float('inf')
            
        for i in range(rows):
            dp[i][0] = 0
            
        for i in range(1,rows):
            for j in range(1,cols):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else: 
                    dp[i][j] = min( dp[i-1][j], dp[i][j-coins[i-1]] + 1)
                    
        a = dp[rows-1][cols-1]    
        
        if a != float('inf'):            
            return a
        return -1