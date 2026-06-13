## Problem1 (https://leetcode.com/problems/coin-change/)

# Time Complexity: O(M*N) where m is the amount and n is the number of coins
# class Solution:
#     def coinChange(self, coins: List[int], amount: int) -> int:
        # Region Recursive solution

        # def findCoins(coins: List[int], amount: int, index: int, coinsUsed: int):
        #     # base
        #     if index >= len(coins) or amount < 0:
        #         return -1
        #     if amount == 0:
        #         return coinsUsed
             
        #     # case choose the coin
        #     case0 = findCoins(coins, amount, index + 1, coinsUsed)
        #     # case not choose the coin
        #     case1 = findCoins(coins, amount - coins[index], index, coinsUsed + 1)

        #     if case0 == -1:
        #         return case1
        #     if case1 == -1:
        #         return case0
            
        #     return min(case0, case1)
        
        # return findCoins(coins, amount, 0, 0)
        # End Region Recursive solution

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        """
        Algorithm: Dynamic Programming (1D Tabulation)
        We use a 1D array `minCoins` where the index `i` represents the target amount, 
        and the value at `minCoins[i]` represents the minimum number of coins needed 
        to make that amount.
        
        Time Complexity: O(C * A)
        Where C is the length of `coins` and A is the `amount`.
        We have a nested loop: the outer loop runs C times, and the inner loop runs A + 1 times.
        
        Space Complexity: O(A)
        Where A is the `amount`. We use a single 1D array of size A + 1 to store the subproblem results.
        """
        
        # Initialize the DP array with `amount + 1` (a placeholder for "infinity").
        # The maximum possible coins we could ever use is `amount` (if using only 1-value coins), 
        # so `amount + 1` acts as an unreachable max value.
        minCoins = [(amount + 1) for _ in range(amount + 1)]
        
        # Base case: 0 coins are needed to make an amount of 0
        minCoins[0] = 0
        
        # Iterate through each coin denomination available
        for c in coins:
            # For each coin, compute the minimum coins needed for every amount up to `amount`
            for i in range(amount + 1):
                if i < c:
                    # If the current amount `i` is strictly less than the coin's value, 
                    # we can't use this coin. We keep the previous best count.
                    continue
                else:
                    # If we CAN use the coin, the optimal choice is the minimum between:
                    # 1. Not using the coin at all (keeping the current `minCoins[i]`)
                    # 2. Using the coin (1 + the optimal solution for the remaining amount `i - c`)
                    minCoins[i] = min(minCoins[i], 1 + minCoins[i - c])
                    
        # The final answer for the requested amount is at the end of our DP array
        result = minCoins[-1]
        
        # If the result is still >= amount + 1, it means the amount cannot be made 
        # with any combination of the given coins, so we return -1.
        return -1 if result >= amount + 1 else result