class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0: 
            return 0
        
        return self.helper(coins,amount,0,0)
    
    def helper(self, coins, amount, index, minimum):
        if (amount == 0):  
            return minimum
        if (amount < 0 or index  == len(coins)): 
            return -1
        
        
        case1 = self.helper(coins, amount - coins[index], index, minimum+1)
        
        case2 = self.helper(coins, amount,  index+1, minimum)
        
        if case1 ==  -1: 
            return case2
        if case2 ==  -1: 
            return case1
        
        return min(case1,case2)
    