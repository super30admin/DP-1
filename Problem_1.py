"""
Time Complexity : O(m*n) whene m is numbr of coins and n is the amount
Space Complexity : O(M*n) as it is a 2D matrix
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
We first tried the recursive approach which gave time limit exceeded. Then we shifted to Dynamic Programming
solution. Here we abalysed that there are 2 parameters on which are soltion depends, them being number
of coins and amount. So we made a 2D matrix with m+1 rows and n+1 columns. We made an extra row for 0
as it would help us in calculation. For 0, we fill in infinity, as infinite 0s would be required to form a sum 
of more than 0. For other rows, we keep on checking for minimum number of coinsif we select that particular coin
or not. Return the last element.
"""


class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if not coins:
            return 0
        dp = [[0 for i in range(amount+1)] for j in range(len(coins)+1)]
        m = len(dp)
        n = len(dp[0])
        for i in range(1, n):
            dp[0][i] = float('inf')
        for i in range(1, m):
            for j in range(1, n):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]])
        if dp[-1][-1] == float('inf'):
            return -1
        return(dp[-1][-1])


#     def coinChange(self, coins, amount):
#         """
#         :type coins: List[int]
#         :type amount: int
#         :rtype: int
#         """
#         if not coins:
#             return 0
#         return self.helper(coins,amount,0,0)
#     def helper(self,coins,amount,index,minimum):
#         if amount==0:
#             return minimum
#         if index==len(coins) or amount<0:
#             return -1

#         case1=self.helper(coins,amount,index+1,minimum)
#         case2=self.helper(coins,amount-coins[index],index,minimum+1)
#         if case1==-1:
#             return case2
#         if case2==-1:
#             return case1
#         return min(case1,case2)
