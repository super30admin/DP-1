class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0:
            return 0
        m = len(coins)
        n = amount
        dp = [[0 for i in range(n+1)] for i in range(m+1)]
        print(dp)

        for i in range(1,len(dp[0])):
            dp[0][i] = sys.maxsize
            
        

        for i in range(1,m+1):
            for j in range(1,n+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j],1+dp[i][j-coins[i-1]])

        if dp[m][n] > amount:
            return -1
        else:
            return dp[m][n]