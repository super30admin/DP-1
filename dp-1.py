# problem 1 : 322. Coin Change : https://leetcode.com/problems/coin-change/
# Time Complexity : O(N * S) where N is the amount and S is the number of coins 
# Space Complexity : O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
#         ## recursive top down approach
#         if amount < 1:
#             return 0
#         dp = [0] * (amount+1)
#         dp[0] = 0
#         return self.getMinCoins(coins,amount, dp)
    
#     def getMinCoins(self, coins, amount, dp):
#         if amount < 0:
#             return -1
#         if amount == 0:
#             return 0
#         if dp[amount] != 0:
#             return dp[amount]
        
#         minValue = float(inf)
#         for coin in coins:
#             res = self.getMinCoins(coins, amount-coin, dp)
#             if res >= 0 and res < minValue:
#                 minValue = res + 1
#         dp[amount] = minValue if minValue != float(inf) else -1
#         return dp[amount]
        
        ## bottom up approach
        if amount == 0:
            return 0
        dp = [float(inf)] * (amount+1)
        for coin in coins:
            if coin < len(dp):
                dp[coin] = 1
        dp[0] = 0
        for i in range(1,len(dp)):
            for coin in coins:
                if i - coin >= 0:
                    dp[i] = min(dp[i], dp[i-coin]+1)
        return dp[-1] if dp[-1] != float(inf) else -1

        
# problem 2 : 198. House Robber : https://leetcode.com/problems/house-robber/
# Time Complexity : O(N) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
  
 class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        withNum = nums[0]
        withoutNum = 0
        for num in range(1,len(nums)):
            temp = withoutNum
            withoutNum = max(withNum, withoutNum)
            withNum = temp + nums[num]
        return max(withNum, withoutNum)
     
        
        
        
        
        
        
        
    
