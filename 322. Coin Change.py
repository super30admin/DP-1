class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = [float('inf')] * (amount +1)
        dp[0] = 0
        for coin in coins:
            for i in range(coin, amount+1):
                dp[i] = min(dp[i], dp[i-coin] +1)
        if dp[amount] == float('inf'):
            return -1
        return dp[amount]

"""
Time Complexity: O(n*amount)
Space Complexity: O(n)

"""