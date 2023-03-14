# Time Complexity : O(n+m) where n: Length of the coins array and m : value of amount
# Space Complexity  : O(m)

from typing import List
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # Initialize a dp array of size amount+1 with infinity values
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0 # base case
        
        for i in range(1, amount + 1):
            for coin in coins:
                if i - coin >= 0:
                    dp[i] = min(dp[i], dp[i - coin] + 1)
        
        return dp[amount] if dp[amount] != float('inf') else -1
