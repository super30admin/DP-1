# Time: O(n*m)
# Space: O(n*m)
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = [[0 for x in range(amount+1)] for y in range(len(coins)+1)]
        #print(dp)
        #dp[0][0] = 0
        for i in range(1, amount+1):
            dp[0][i] = amount+1
        
        for i in range(1, len(coins)+1):
            dp[i][0] = 0
            
        for i in range(1, len(coins)+1):
            for j in range(1,amount+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]])
        if dp[len(coins)][amount] == amount+1:
            return -1
        else:
            return dp[len(coins)][amount]
            
