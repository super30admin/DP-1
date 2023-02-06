# Author: Naveen US
# Title: Coin Change 1
# Time Complexity : O(M*N), M - the amount and N - length of coins array. 
# Space Complexity : O(M*N),  M - the amount and N - length of coins array.
# Did this code successfully run on Leetcode : Yes.

#Any problem you faced while coding this : Found the coding part a little difficult, should get better with practice 

class Solution:
    def handler(self, coins, amount, index, minimum, infinity, dp):
        if amount>=infinity:
            dp[index][infinity]=infinity
            return infinity
        elif index>len(coins) or index<=0:
            return infinity
        elif amount==infinity-1:
            dp[index][amount] = 0
            return 0
        else:
            if dp[index][amount]==None:
                min_case1 = self.handler(coins, amount, index-1, minimum, infinity, dp)
                min_case2 = self.handler(coins, amount+coins[index-1], index, minimum+1, infinity, dp)      
                dp[index][amount] = min(min_case1, min_case2+1)
            return dp[index][amount]

    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount==0:
            return 0
        dp=[[None for i in range(amount+2)] for j in range(len(coins)+2)]
        for i in range(amount+2):
            dp[0][i]=amount+1
            dp[len(coins)+1][i]=amount+1
        for j in range(1,len(coins)+2):
            dp[j][amount+1]=amount+1

        minimum = 0
        min_final = self.handler(coins, 0, len(coins), minimum, amount+1, dp)
        if min_final>amount:
            return -1
        else:
            return min_final
