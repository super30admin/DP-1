#https://leetcode.com/problems/coin-change/
#time-o(n)
#space-o(m*n) where m is amount and n is len(coins)
import sys
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if not coins:
            return 0
        dp = [[0]*(amount+1)]*(len(coins)+1)
        #print(dp)
        for j in range(1,amount+1):
            dp[0][j]=amount+1
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j < coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
        return -1 if dp[len(coins)][amount]==amount+1 else dp[len(coins)][amount]
        
                
                
                
                