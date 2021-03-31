#!/usr/bin/env python
# coding: utf-8

# In[2]:


# The Time and space complexity will always be O(mxn)
# m = no of coins, n = amount
# The biggest challenge here is the formation of the matrix and keeping
# track of the indices.

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins is None or len(coins) == 0:
            return -1
        # Create a dynamic Array
        dp = [[0 for _ in range(amount +1)]  for _ in range(len(coins)+1)]
        # Lets initialize the arrays first row with amount +1, Here amount +1
        for i in range(len(dp[0])):
            dp[0][i] = amount +1
            
        # Now lets fill up the dp array with the values
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j],dp[i][j-coins[i-1]]+1)
                    
        if dp[len(dp)-1][len(dp[0])-1] == amount + 1:
            return -1
        else:
            return dp[len(dp)-1][len(dp[0])-1]
        

