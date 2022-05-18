#Time Complexity : O(mn) where m ->steps required to reach denomination to reach amount n->denomination of coin
#Space Complexity: O(mn) as we are using matrix because we have two decision making parameters in dp.
#Approach: By using recursion we were getting Time Complexity in expodential so shifted to dp.
#Did your code run on leetcode: yes

import numpy as np
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if (coins==[] or len(coins) == 0): return 0
        
        rows = len(coins) + 1
        cols = amount + 1
        size = rows*cols
 
        dp = np.array([0]*size).reshape(rows,cols) 
        
        for j in range(1,len(dp[0])):
            dp[0][j] = 99999
        
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j] , dp[i][j-coins[i-1]]+1)

        result = dp[len(dp)-1][len(dp[0])-1]
        if result >= 99999: return -1
        return result
    
        
    

