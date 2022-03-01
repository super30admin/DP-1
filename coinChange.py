# // Time Complexity :O(amt.coins)
# // Space Complexity :O(amt)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :No
class Solution:
    def coinChange(self, coins, amount: int):

        dp=[amount+1]* (amount+1)
        #base case given if amout is 0 return 0
        dp[0]=0

        for amt in range(1,amount+1):
            for co in coins:
                # a-c is non -ve
                if amt-co >=0:
                #min(notchoose coin, choose coin )
                    dp[amt]= min(dp[amt], 1 + dp[amt-co])
      
        if dp[amount]!=amount+1:
            return dp[amount]
        else:
            return -1
        