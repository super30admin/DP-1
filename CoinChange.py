# Exhasutive approach
# Time limit exceeds but code works

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
     
        
        def helper(amount,coins,index,coinsUsed):
            
            if amount == 0:
                return coinsUsed
            if amount < 0 or index == len(coins):
                return -1
#           Choose
            case1 = helper(amount - coins[index],coins,index,coinsUsed+1)
#           Not Choose
            case2 = helper(amount,coins,index+1,coinsUsed)
    
            if case1 == -1:return case2
            if case2 == -1:return case1
        
            return min(case1,case2)
            
                
            
            
        return helper(amount,coins,0,0)
        
        
        