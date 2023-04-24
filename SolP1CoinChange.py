"""
2D array - amount versus coins. 2 choices for a coin denomination - choose it, do not choose it. 
TC= O(N*M) where N= length of amounts, M = length = denominations

// Did this code successfully run on Leetcode : Yes
"""


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0:
            return 0
        dp = [[0 for x in range(0, amount+1)] for x in range(0, len(coins) + 1)]
        for j in range(1, amount + 1):
            dp[0][j] = amount + 1
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]       #not choose
                else:
                    dp[i][j] = min(dp[i-1][j], #choose
                    dp[i][j-coins[i-1]] + 1)   
        # print(dp)
        if dp[-1][-1] >= amount + 1:        #in case you end up not choosing and not getting any results
            return -1
        return dp[-1][-1]