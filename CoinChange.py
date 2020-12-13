# Approach: We used dynamic programming apporach using recurssion here. What we are doing is asking the algorithm if selecting a praticular coin at particular intsance will give me a solution or not. We collect all the solutions from different branches of recurssion tree and return the one that had the least depth.

# We always make two decisions(branches):
# Case1: Select that coin
# Case2: Dont select that coin
# If you choose case1 then substract that denomination from the target amount and increase the depth count by 1 
# If you choose case2 then we need to move on to the next denomination and no change will be done to original remaining amount.

# Algorithm will keep doing this until it reaches the following two conditions:
# 1) Remaining amount has became 0. That means we have reached a solution for that branch
# 2) Remaining amount has became less than 0 that makes that branch an invalid branch.

# Time Complexity: O(n) where n= length of the nums array
# Space Complexity: O(1) 


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        if not coins:
            return -1
        
        # helper(<coins>,<amount>,<start-index>,<minimum coins>)
        return self.helper(coins,amount,0,0)
    
    def helper(self, coins, amount, index, count):
        
        #base
        if amount == 0:
            return count
        
        if index == len(coins) or amount < 0 :
            return -1
        
        #logic
        # choose the coin
        case1 = self.helper(coins, amount - coins[index], index, count+1)
        
        # do not choose the coin
        case2 = self.helper(coins, amount, index+1, count)
        
        if case1 == -1:
            return case2
        if case2 == -1:
            return case1
        return min(case1,case2)
        
        
            
        