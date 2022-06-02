# Time Complexity : O(m*n) where is m is number of coins and n is range of the amount
# Space Complexity : O(m*n) where is m is number of coins and n is range of the amount
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[0 for i in range(amount+1)] for j in range(len(coins)+1)]
        
        for j in range(1, amount+1):
            dp[0][j] = amount + 1
        
        
        for i in range(1, len(coins) + 1):
            for j in range(0, amount + 1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])
                    
                    
        return dp[len(coins)][amount] if dp[len(coins)][amount] <= amount else -1