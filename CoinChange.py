#322. Coin Change
"""
Time Complexity : O(n^2)
Space Complexity : O(coins+1 * target+1)
"""
class Solution:
    
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins)#row
        n = amount#column
        
        dp = [[0] * (n+1) ] * (m+1)

        for i in range(1, len(dp[0])):
            #dp[0][0] = 0 is already initialized
            dp[0][i] = amount + 1

        for c in range(1, len(dp)):
            for a in range(1, len(dp[0])):
                if a < coins[c-1]:
                    dp[c][a] = dp[c-1][a]
                else:
                    dp[c][a] = min(dp[c-1][a], 1 + dp[c][a-coins[c-1]])
        
        if dp[m][n] > amount:
            return -1
        else:
            return dp[m][n]
        
        
        
