#Time Complexity: O(n*m) where n is the amount and m is the number of coins
#Space Complexity: O(n) where n is the amount

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        n = amount
        dp = [99999] * (n + 1)
        dp[0] = 0

        for coin in coins:
            for j in range(coin, n + 1):
                dp[j] = min(dp[j], 1 + dp[j - coin])

        return -1 if dp[n] == 99999 else dp[n]