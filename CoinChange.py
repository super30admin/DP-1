"""
Time Complexity : O(mn)
Space Complexity : O(mn)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def coinChange(self, coins, amount):
        dp = [[0]*(amount+1) for i in range(len(coins)+1)]
        rows = len(dp)
        cols = len(dp[0])
        
        for i in range(rows):
            dp[i][0] = 0
        
        for i in range(1, cols):
            dp[0][i] = 9999
            
        for i in range(1, rows):
            for j in range(1, cols):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1)
        
        result = dp[-1][-1]
        if result >= 9999:
            return -1
        return result

s = Solution()
print(s.coinChange([1,2,5], 11))