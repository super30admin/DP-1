class Solution:
    def coinChange(self, coins: list[int], amount: int) -> int:
        if coins == None and len(coins) == 0:
            return -1
        
        m = len(coins)
        n = amount
        
        dp = [[0]*(n+1)]*(m+1)
        
        for i in range(1,n+1):
            dp[0][i] = amount+1
        
        for i in range(1,m+1):
            for j in range(1,n+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]])
        if dp[m][n] == amount+1:
            return -1
        else:
            return dp[m][n]
               
#time complexity ---> O(m*n)
#space complexity ---> O(m*n)


