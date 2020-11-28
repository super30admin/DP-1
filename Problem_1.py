# Coin Change Problem

# Time Complexity : O(S∗n) where S is the amount and n is the coins denominations
# Space Complexity : O(S) as extra space for 2D array(table) is used.
# Did this code successfully run on Leetcode : Yes, Runtime: 2932 ms and Memory Usage: 18.6 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
 The Brute force approach of receursion and Greedy algorithm failed so used Dynamic Programming approach which uses 2 dimensional array to solve the problem
 with amount values being rows and coins denominations as columns. Traversing across
 the array and finding the minimum of counts for amounts up to i i.e 0 to 11.

"""
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp=[[float("inf") for x in range(amount+1)] for x in range(len(coins)+1)] # Initializing 2 dimensional array
        for i in range(len(coins)+1):
            dp[i][0]=0
        for i in range(len(coins)+1): # Traversing 2d array dp
            for j in range(amount+1):
                if(j<coins[i-1]):
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i-1]])
        if(dp[len(coins)][amount]==float("inf")):
            return -1
        else:
            return dp[len(coins)][amount]