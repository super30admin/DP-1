# Time Complexity : O(m*n) where is m is number of coins and n is range of the amount
# Space Complexity : O(n) where n is range of the amount
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [0 for i in range(amount+1)]
        
        for j in range(1, amount+1):
            dp[j] = amount + 1
        
        
        for i in range(1, len(coins) + 1):
            for j in range(0, amount + 1):
                if j < coins[i-1]:
                    continue
                else:
                    dp[j] = min(dp[j], 1 + dp[j - coins[i-1]])
                    
                    
        return dp[amount] if dp[amount] <= amount else -1