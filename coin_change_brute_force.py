
# Time Complexity : Add - O(mn)
# Space Complexity :O(mn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Despite O(mn), my solution was only better than 14% of python submissions

'''
1. I have used a Table Approach as described in the lecture
'''

class Solution:
    def coinChange(self, coins, amount):
        
        if coins == [] or len(coins) < 1:
            return -1
        
        cols = amount + 1
        rows = len(coins) + 1
        
        dp = []
        for i in range(rows):
            lis = [9999 if (i == 0 and j>=1) else 0 for j in range(cols)]
            dp.append(lis)
            
        for i in range(1, rows):
            for j in range(1,cols):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]] + 1)
                    
                    
        if dp[rows-1][cols-1] >= 9999:
            return -1
        else:
            return dp[rows-1][cols-1]