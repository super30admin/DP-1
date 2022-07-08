# Time Complexity: o(m*n)
# Space Complexity: o(m*n)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        if amount == 0:
            return 0
        if amount < min(coins):
            return -1
        m = len(coins)+1
        n = amount+1
        dp = [[0]*n]*m
    
        for i in range(1,len(dp[0])):
            dp[0][i] = amount+1   #infinity
            
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j<coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j],1+dp[i][j-coins[i-1]])
        if dp[m-1][n-1] == amount+1:    #infinity
            return -1
        return dp[m-1][n-1]