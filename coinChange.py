class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        m = len(coins) + 1
        n = amount + 1
        
        dp = [[0 for j in range(n)] for i in range(m)]
        
        
        for i in range(1, n):
            dp[0][i] = 99999
        
        for i in range(1, m):
            for j in range(1, n):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    temp = dp[i][j-coins[i-1]]
                    dp[i][j] = min(dp[i-1][j], 1+temp)
        if dp[m-1][n-1] == 99999:
            return -1
        else:
            return dp[m-1][n-1]
                    
