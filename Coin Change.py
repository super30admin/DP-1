# TC : O(len(coins)*amount)
# SC : O(amount)
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """        
        dp=[float("inf")] * (amount+1)
        dp[0]=0
        for coin in coins:
            for i in range(coin, amount+1):
                if i-coin>=0:
                    dp[i]=min(dp[i], dp[i-coin]+1)

        return -1 if dp[-1]==float("inf") else dp[-1]