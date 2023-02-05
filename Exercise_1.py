#Time Complexity : O(M*N), M being the amount and N being the length of coins. 
#Space Complexity : O(M*N), M being the amount and N being the length of coins. 
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : I had trouble changing the recursive way 
#into dp solution. For some reason, I think I flipped the index or matrix, and so I had
#to really debug. I think I might have been trying to two two ways at the same time or 
#something. 

#Your code here along with comments explaining your approach in three sentences only
'''Using dynamic programming to find all the ways while saving any repeated values. 
'''
class Solution:
    def handler(self, coins, amount, index, minimum, infinity, dp):
        #base case of recursion. 
        if amount>=infinity:
            dp[index][infinity]=infinity
            return infinity
        elif index>len(coins) or index<=0:
            return infinity
        elif amount==infinity-1:
            dp[index][amount] = 0
            return 0
        else:
            #if dp value is none, calculate the next values, or take the value from dp. 
            #find the minimum of the two cases. 
            if dp[index][amount]==None:
                min_case1 = self.handler(coins, amount, index-1, minimum, infinity, dp)
                min_case2 = self.handler(coins, amount+coins[index-1], index, minimum+1, infinity, dp)      
                dp[index][amount] = min(min_case1, min_case2+1)
            return dp[index][amount]
        
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount==0:
            return 0
        #define initial dp with amount+1 as "infinity" and 0s on the edges. 
        dp=[[None for i in range(amount+2)] for j in range(len(coins)+2)]
        for i in range(amount+2):
            dp[0][i]=amount+1
            dp[len(coins)+1][i]=amount+1
        for j in range(1,len(coins)+2):
            dp[j][amount+1]=amount+1

        #call handler. 
        minimum = 0
        min_final = self.handler(coins, 0, len(coins), minimum, amount+1, dp)
        #if final resolution is infinity, return -1. 
        if min_final>amount:
            return -1
        else:
            return min_final