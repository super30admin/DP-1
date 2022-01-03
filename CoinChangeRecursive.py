# // Time Complexity : 2^N
# // Space Complexity : 2^N
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        return self.helper(amount, coins, 0 , 0)
    
    def helper(self, amount, coins, index, coinsUsed):
        if amount == 0:
            return coinsUsed
        if amount < 0 or index == len(coins):
            return -1
        
        #case1: choose the coin
        case1 = self.helper(amount - coins[index], coins, index, coinsUsed+1)
        #case1: not choosing the coin
        case2 = self.helper(amount, coins, index+1, coinsUsed)
        
        if case1 == -1: return case2
        if case2 == -1: return case1
        
        return min(case1, case2)
        