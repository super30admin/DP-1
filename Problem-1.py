class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        #edge case
        if coins is None or len(coins)==0:
            return 0

        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        m = len(dp); n = len(dp[0])

        for j in range(1,n):
            dp[0][j] = 9999

        for i in range(1,m):
            for j in range(1,n):
                if j < coins[i-1]:
                    dp[i][j]= dp[i-1][j]
                else:
                    dp[i][j]= min(dp[i-1][j],1+dp[i][j-coins[i-1]])

        if dp[m-1][n-1] >= 9999:
            return -1
        return dp[m-1][n-1]
