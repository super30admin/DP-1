'''
Implementation: Bottom-up approach of DP
Time complexity: O(amount * len(coins))
Space complexity: O(amount)
'''
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0
        
        for a in range(1, amount + 1):
            for coin in coins:
                if a - coin >= 0:
                    dp[a] = min(dp[a], 1 + dp[a - coin])
                    
        if dp[amount] != amount + 1:
            return dp[amount]
        else:
            return -1