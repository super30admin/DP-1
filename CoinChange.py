'''
Top Down Approach
Time Complexity - O(N*C)
Space Complexity - O(N) Implicit stack

'''

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        if len(coins)==0 or amount<=0:
            return 0
        
        count = [0]*(amount+1)
        return self.helper(coins,amount,count)
    
    def helper(self,coins,rem,count):
        
        if rem<0:
            return -1
        if rem ==0:
            return 0
        
        if count[rem-1]!=0:
            return count[rem-1]
        
        minimum = float("inf")
        
        for coin in coins:
            #if coin<=rem:
            result = self.helper(coins,rem-coin,count)
            if result>=0 and result <minimum:
                minimum = result+1
          
        if minimum == float("inf"):
            count[rem-1]=-1
        else:   
            count[rem-1]= minimum
        
        return count[rem-1]

'''

Bottom Up approach Dynamic Programming
Time Complexity - O(N*C) where N is the total amount and C is the number of different coins provided
Space Complexity - O(N) N = total amount


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        if len(coins)==0 or amount ==0:
            return 0
        
        dp = [amount+1] * (amount+1)
        
        dp[0]=0
        
        for amt in range(1,amount+1):
            for coin in coins:
                if coin <= amt:
                    dp[amt] = min(dp[amt-coin]+1,dp[amt])
                    
        if dp[amount]>amount:
            return -1
        
        return dp[amount]
        
'''
            