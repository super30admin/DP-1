import sys

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        #DP- BottomUp
        dp = [[(amount+1)]*(amount+1)]*(len(coins)+1)
        dp[0][0] = 0
        for i in range(len(dp)):
            for j in range(len(dp[0])):
                if (j<coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1) 
        result = dp[len(dp)-1][len(dp[0])-1]
        if result > amount: return -1
        return result
        
        
        #Exhaustive approach
#         def helper(amount, coins, index, coinsUsed):
#             # Base Condition
#             if amount == 0: return coinsUsed
#             if amount < 0 or index == len(coins): return -1
#             # Logic
#             case1 = helper((amount-coins[index]), coins, index, coinsUsed+1)
#             case2 = helper(amount, coins, index+1, coinsUsed)
#             if case1 == -1: return case2
#             if case2 == -1: return case1
#             return min(case1, case2)

#         return helper(amount, coins, 0, 0)
        
#         if len(coins) == 1:
#             if coins[0] == amount:
#                 return 1
#             elif coins[0] < amount:
#                 return -1
#             else:
#                 return 0

#         if amount < 0:
#             return sys.maxint
#         if amount == 0:
#             self.min_count = self.count
#         self.count += 1
#         for i in range(len(coins)):
#             self.min_count = min(self.min_count, self.coinChange(coins, (amount-coins[i])))
#         self.count -= 1
#         return self.min_count