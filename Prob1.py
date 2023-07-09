# Time Complexity: O(m*n) where n = length of amounts, m = length of denominations
# Space Complexity: O(m*n) where n = length of amounts, m = length of denominations
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
    
    #Method 1 - Recursion
    #     return self.helper(coins,amount,0,0)
    
    # def helper(self,coins,amount,i,coinsUsed):
        
    #     if amount==0: return coinsUsed
    #     if amount<0 or i==len(coins): return -1

    #     case1=self.helper(coins,amount-coins[i],i,coinsUsed+1) #1 case
    #     case2=self.helper(coins,amount,i+1,coinsUsed)    #0 case
    #     if case1==-1: return case2
    #     if case2==-1: return case1
    #     return min(case1,case2)

    #Method 2 - DP with 2D space
        if len(coins)==0: 
            return -1
        
        dp=[[0 for _ in range(0,amount+1)] for _ in range(0,len(coins)+1)]
        for j in range(1,amount+1):
            dp[0][j]=99999 #ifinity
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if j<coins[i-1]:                   
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j], 1+dp[i][j-coins[i-1]]) #zero case and choose 1 case respectively
        if dp[-1][-1] >= 99999:        #in case you end up not choosing and not getting any results
            return -1
        return dp[-1][-1]





#Here it's coins[i-1] and not coins[i] because in the matrix we have added a dummy row and column, and also we iterate from index 1 here and not 0th index