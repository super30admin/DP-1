# S30 Big N Problem #19 {Medium}
# Leetcode #322

# You are given coins of different denominations and a total amount of money. 
# Write a code to compute the minimum number of coins that you need to use to make up the amount.
# If that amount of money cannot be made up, return -1.

# Time Complexity : O(n*m) n= no. of coins, m=amount
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach:
# Build a DP array of no. of coins as rows and amounts as columns
# Fill in the first row with default values
# For values from the next row, select the min. value of prev. coin or min. coins required using current coin. 

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        dp=[[ 0 for _ in range(amount+1)]for _ in range(len(coins)+1)]
        
        for i in range(amount+1):
            dp[0][i]=float('inf')
        
        
        for i in range(1,len(coins)+1,1):
            for j in range(1,amount+1,1):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i-1]])
        
        if dp[len(coins)][amount]==float('inf'):
            return -1
        else:
            return dp[len(coins)][amount] 

