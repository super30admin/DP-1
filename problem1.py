#Time Complexity O (m * n)
#SpaceComplexity O (m * n)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[0 for c in range(amount+1)] for r in range(len(coins)+1)]
        for x in range(len(coins) + 1):
            dp[x][0] = 0
        for y in range(1, len(dp[0])):
	        dp[0][y] = 9999
        for x in range(1,len(dp)):
            for y in range(1,len(dp[0])):
                if y < coins[x-1]:
                    dp[x][y] = dp[x-1][y]
                else:
                    dp[x][y] = min(dp[x-1][y],dp[x][y-coins[x-1]]+1)
        if dp[-1][-1]>= 9999:
            return -1
        return dp[-1][-1]
