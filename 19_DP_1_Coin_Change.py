#Time Complexity : O(N*S) where N is the number of denomination and S is the amount
#Space Complexity : O(S) for using one extra array of amount size
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Need to go through the Jaspinder Video first,  then got the idea. The idea is still taking time for me for Dynamic Programming questions


#Your code here along with comments explaining your approach

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp=[float('inf')]*(amount+1)
        dp[0]=0
        for coin in coins: 
            for x in range(coin, amount+1): 
                dp[x]=min(dp[x],1+dp[x-coin])
        
        if dp[amount]!=float('inf'): 
            return dp[amount]
        else: 
            return -1
            