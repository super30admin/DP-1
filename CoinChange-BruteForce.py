"""
Time Complexity : O(2^n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Time Limit exceed
Any problem you faced while coding this : No
"""
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0:
            return 0
        return self.helper(coins, amount, 0, 0)
    
    def helper(self, coins: List[int], amount: int, index: int, minCoins: int) -> int:
        # Base case
        if amount == 0:
            return minCoins
        if index >= len(coins) or amount < 0:
            return -1
        
        # Logic
        # Don't choose case
        case1 = self.helper(coins, amount, index + 1, minCoins)
        
        # Choose case
        case2 = self.helper(coins, amount - coins[index], index, minCoins + 1)
        
        if case1 == -1:
            return case2
        if case2 == -1:
            return case1
        return min(case1, case2)