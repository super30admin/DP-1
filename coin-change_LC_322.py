#TC: O(coins.length * amount) SC: O(coins.length * amount)
#dynamic programming
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not coins:
            return 0

        row = len(coins) + 1
        col = amount + 1
        
        dp=[[None for i in range(col)] for j in range(row)]
        
        for i in range(row):
            dp[i][0]=0

        for i in range(col):
            dp[0][i]=float("inf")

        for i in range(1,row):
            for j in range(1,col):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]

                else: 
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1)

        if dp[row-1][col-1] == float("inf"):
            return -1

        else:
            return dp[row-1][col-1]
