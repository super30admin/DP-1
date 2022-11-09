# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No

import sys

class Solution(object):
    def coinChange(self, coins, amount):
        
        # EDGE CASE
        if amount == 0:
            return 0
        
        # INIT DIMENSIONS
        nrows = len(coins) + 1
        ncols = amount + 1
        
        # BY DEFAULT, 2**64 DENOTES IMPOSSIBLE TO MAKE CHANGE
        dp = [[2**64 for _ in range(ncols)] for _ in range(nrows)]
        
        # BY DEFAULT, IF AMOUNT = 0, WE NEED EXACTLY 0 COINS
        for i in range(nrows):
            dp[i][0] = 0
            
        # OTHER CELLS
        for i in range(1, nrows):
            for j in range(1, ncols):
                
                # CASE 1 - WE MUST LEAVE THE COIN
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                
                # CASE 2 - WE CAN TAKE OR LEAVE THE COIN
                else:
                    take = 1 + dp[i][j - coins[i - 1]]
                    leave = dp[i - 1][j]
                    dp[i][j] = min(take, leave)
            
        return -1 if dp[-1][-1] == 2**64 else dp[-1][-1]
            