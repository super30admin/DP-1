""""// Time Complexity : O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
class Solution:
    def coinChange(self, coins, amount):
        m = len(coins)
        n = amount
        dp = [[0 for i in range(n+1)] for j in range(m+1)]

        for j in range(1, len(dp[0])):
            dp[0][j] = 99999

        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j-coins[i-1]])
        if dp[m][n] >= 99999:
            return -1

        return dp[m][n]
#Exhaustive approach-
# class Solution:
#     def coinChange(self, coins, amount):
#         return self.helper(coins, 0, amount, 0)
#     def helper(self, coins, index, amount, minCoins):
#         #base
#         if amount==0:
#             return minCoins
#         if amount<0 or index==len(coins):
#             return -1
#
#         #logic
#         case1=self.helper(coins,index,amount-coins[index], minCoins+1)
#         case2=self.helper(coins,index+1,amount, minCoins)
#
#         if case1==-1:
#             return case2
#         if case2==-1:
#             return case1
#         return min(case1, case2)
#
# Obj=Solution()
# print(Obj.coinChange([1,2,5],11))
