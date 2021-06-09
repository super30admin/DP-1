"""
Coin Change - 1 

Time Complexity : O(2^n) where n is number of denominations. 
Space Complexity : O(m+n).
    
"""

class Solution:
    def helper(self, coins, amount, index, min_coin):
        
        if amount == 0: return min_coin
        if amount < 0 or index == len(coins): return -1 
        
        case1 = self.helper(coins, amount - coins[index], index, min_coin + 1)
        case2 = self.helper(coins, amount, index + 1, min_coin)
        
        if case1 == - 1: return case2 
        if case2 == -1: return case1 
        
        return min(case1, case2)
        
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0 
        if not coins or len(coins) == 0:
            return 0 
        
        return self.helper(coins, amount, 0, 0)