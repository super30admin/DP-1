# Time Complexity :O(m * n), where m is the number of coins and n is the amount
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes

from ast import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        dp = [float('inf')] * (amount + 1)
        
        dp[0] = 0

        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] = min(dp[i], dp[i - coin] + 1)

       
        if dp[amount] == float('inf'):
            return -1
        else:
            return dp[amount]
