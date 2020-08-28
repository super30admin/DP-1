# 322. Coin Change

# Code:
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # base condition!
        if amount<1:
            return 0
        
        # Initializing the DP array
        dp=[[ float('inf') for _ in range(amount+1)] for j in range(len(coins)+1)]
        
        # For each row, first column is set to 0! 
        # because we can not use any coin to make 0.
        for i in range(len(coins)+1):
            dp[i][0] = 0
        
        # If the amount val is less than coin val, directly copy the result from the above row. 
        # If we have a greater than or equal amount to the coin,
        # we take the min of prev result and 1+ coin[i-1] jumps val
        
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j>=coins[i-1]:
                    dp[i][j] = min(dp[i-1][j] , 1+ dp[i][j-coins[i-1]])
                else:
                    dp[i][j] = dp[i-1][j]
                    
        # Return the last index as result
        if dp[-1][-1]>=float('inf'):
            return -1
        return dp[-1][-1]
                

# Time Complexity: O(n*m)
# Space Complexity: O(n*m)
# Accepted on Leetcode: YES
# Any problems faced: Not after practicing on whiteboard.
                