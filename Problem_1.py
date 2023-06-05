"""
Problem : 1

Recursive
Time Complexity : O(2^(m+n))
Space Complexity : O(2^(m+n))

DP
Time Complexity : O(m*n)
Space Complexity : O(m*n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

In recursive solution - choosing or not choosing the coin
In dp approach - creating a dp matrix and implementing the recursive tree in the form of table from behind
"""

# Approach 1 - Using recursion

class Solution(object):
    def coinChange(self, coins, amount):

        return self.helper(coins,0,amount,0)

    def helper(self,coins,ind,amount,coinsUsed):
        # base case
        if amount==0:
            return coinsUsed
        if amount<0 or ind==len(coins):
            return -1


        # logic

        # choose
        case1=self.helper(coins,ind,amount-coins[ind],coinsUsed+1)
        # or don't choose
        case2=self.helper(coins,ind+1,amount,coinsUsed)
        if case1==-1:
            return case2
        if case2==-1:
            return case1
        return min(case1,case2)
    
    # Approach 2 - Using Dynamic Programming

class Solution(object):
    def coinChange(self, coins, amount):

        dp = [[float('inf')] * (amount + 1) for _ in range(len(coins) + 1)]

        for i in range(len(coins) + 1):
            dp[i][0] = 0

        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                if coins[i - 1] <= j:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])
                else:
                    dp[i][j] = dp[i - 1][j]

        if dp[len(coins)][amount] != float('inf'):
            return dp[len(coins)][amount]
        else:
            return -1


    