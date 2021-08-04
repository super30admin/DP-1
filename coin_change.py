//Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if len(coins)==0:
            return 0
        dp = [[0 for i in range(amount+1) ] for j in range(len(coins)+1)]
        for i in range(0,amount+1):
            dp[0][i] = amount + 1
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j],dp[i][j-coins[i-1]]+1)
        result = dp[len(dp)-1][len(dp[0])-1]
        if result == amount +1:
            return -1
        return result
#         if len(coins) == 0:
#             return 0
#         return self.helper(coins,amount,0,0)  #coins,amount,mincoins,index
#     def helper(self,coins,amount,minCoins,index):
#         #base case
#         if amount == 0:
#             return minCoins
#         if index == len(coins) or amount < 0:
#             return -1
#           #logic 
#           #1.dont choose
#         case1 = self.helper(coins,amount,minCoins,index +1)
#          #//2. choose
#         case2 = self.helper(coins , amount - coins[index],minCoins + 1,index)
#         if case1 == -1:
#             return case2
#         if case2 == -1:
#             return case1
#         return min(case1,case2)