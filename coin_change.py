"""
TC:O(mn) where m is the number of coins and n is the amount.
SC:O(n)
"""
class Solution:
    def coinChange(self, coins: 'List[int]', amount: 'int') -> 'int':
        dp = [0] + [float('inf') for i in range(amount)]
        for i in range(1, amount+1):
            for coin in coins:
                if i >= coin:
                    dp[i] = min(dp[i], dp[i-coin] + 1)
        if dp[-1] == float('inf'):
            return -1
        return dp[-1]