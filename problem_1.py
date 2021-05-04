""" Time Complexity : O(mn)
 Space Complexity : O(mn)
 Did this code successfully run on Leetcode :Yes
 Any problem you faced while coding this : No 
"""

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        if not coins:
            return 0
        dp = [ [99999]*(amount+1) for i in range(len(coins)+1)]
        
        #first column
        for i in range(len(dp)):
            dp[i][0] = 0
            
        #first row
        for j in range(1,len(dp[0])):
            dp[0][j] = amount + 1
            
            
        for i in range(1,len(dp)):
            for j in range(1, len(dp[0])):
                
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j],dp[i][j-coins[i-1]]+1)
                    
        result = dp[len(dp)-1][len(dp[0])-1]
        if result >= amount + 1:
            return -1
        return result
         
        
        
        