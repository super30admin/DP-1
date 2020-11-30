'''
Time complexity: O(N^2)
Space complexity: O(1)
'''

class Solution:
    def coinChange(self, coins ,amount) -> int:

        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        
        for coin in coins:
            for x in range(coin, amount + 1):
                dp[x] = min(dp[x], dp[x - coin] + 1)
        return dp[amount] if dp[amount] != float('inf') else -1 
        
s = Solution()
print(s.coinChange([1,2,5],11))