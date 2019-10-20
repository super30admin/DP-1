#I am getting index out of range error while running the dp solution on Github. 
#Also,I would like to know best way to initialize 2d array in python. 

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[9 for x in range(amount+1)] for y in range(len(coins)+1)]
        for i in range(len(coins)+1):
            dp[i][0] = 0
        for j in range(1,amount+1):
            dp[0][j] = 99999
        n = len(dp)
        m = len(dp[0])
        for i in range(1,n):
            for j in range(1,m):
                if(j < i):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(((dp[i][j-i])+1), dp[i-1][j])
                if(dp[i][j] >= 99999):
                    return -1
        return dp[n-1][m-1]