class Solution:
    
    def helper(self, coins, index, amount, minVal):
        
                
        if amount == 0 :
            return minVal
        
        if index == len(coins) or amount<0:
            return -1
         
        case1 = self.helper(coins, index, amount - coins[index], minVal+1)
        case2 = self.helper(coins, index+1, amount , minVal)
        
        if case1 == -1:
            return case2
        if case2 == -1:
            return case1
        
        return min(case1, case2)
    
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        if coins == None or len(coins) == 0:
            return 0
        
        return self.helper(coins, 0, amount, 0)

#  brute force method. Doing recurssion basically going through all solutions, there is an issue with repeated subproblems here. Time complexity is exponential.
        
