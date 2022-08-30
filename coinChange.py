# Time Complexity: O(2^n) : Exponential
# Space Complexity: O(1)

# Recursion solution. Keep on building on the exhaustive approach of Choosing or not choosing a particular coin.

# The base case would be when the remaining amount is 0 -> we return minCoins
# Or if amount is negative, or the index is out of bounds


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
#         Exhaustive -> Choose or Not Choose

        return self.helper(coins, 0, amount, 0)
    
    def helper(self, coins: List[int], i: int, amount: int, minCoins: int) -> int:
        
#         Base Case
        if amount == 0:
            return minCoins
        if (amount < 0) or (i == len(coins)):
            return -1
#         Choose

        case1 = self.helper(coins, i, amount - coins[i], minCoins + 1)
        case2 = self.helper(coins, i + 1, amount, minCoins)
        if case1 == -1: 
            return case2
        if case2 == -1:
            return case1
        
        return min(case1, case2)
