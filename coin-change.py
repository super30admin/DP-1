# Time Complexity: O(n * m) where n is the number of denominations of coins and m is the target amount
# Space complexity: O(n * m)

# The code ran on Leetcode successfully.

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0 or coins == None:
            return -1
        
        m = len(coins)
        n = amount
        dp = [[0] * (n+1)] * (m+1)
        
        for i in range(1, n+1):
            dp[0][i] = amount + 1
            
        for i in range(1, m+1):
            for j in range(1, n+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                    
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j-coins[i-1]])
                    
        if dp[m][n] == amount + 1:
            return -1
        
        return dp[m][n]           
        
# ^^^^^ Storing the sub problems in form of a table for use if they overlap. ^^^^^^        
