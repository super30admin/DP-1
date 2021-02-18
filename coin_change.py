# Time complexity - O(m*n) (where n = length of the array, m = amount)
# Space Complexity: O(m)  (where m = amount)
# Problems faced while coding this:None
# Approach : Top Down Memoization DP approach.
        
class Solution:
    def coinChange(self,coins:List[int],amount:int) -> int:
        
        rows = len(coins)+1
        cols = amount + 1
        dp = [[None for i in range(cols) ]for j in range(rows)]
        
        for i in range(rows):
            dp[i][0] = 0
            
        for j in range(1,cols):
            dp[0][j] = float("inf")
            
        
        for coin in range(1,rows):
            
            for amt in range(1,cols):
                
                if coins[coin-1] > amt :
                    dp[coin][amt] = dp[coin-1][amt]
                    
                else:
                    dp[coin][amt] = min(dp[coin-1][amt],dp[coin][amt-coins[coin-1]]+1)
                    
        if (dp[coin][amount]) == float("inf"): return -1
        else: return dp[coin][amount]
        
        