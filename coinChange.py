# Time Complexity : O(n*m) where n is the number of coins and m is the amount
# Space Complexity : O(n*m) where n is the number of coins and m is the amount
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# Using the tabular DP approach
# 1. We create a 2D array with rows as the number of coins and columns as the amount.
# 2. We initialize the first row with infinity, as we cannot generate any amount with 0 coins and the first column with 0, as the amount 0 can be made with 0 coins.
# 3. We iterate through the array and fill the values based on the following conditions:
#     a. If the amount is less than the coin value, we take the value from the previous row.
#     b. If the amount is greater than or equal to the coin value, we take the minimum of the value from the previous row and 1 + the value at the same row and the column - coin value.
# 4. If the value at the last row and last column is infinity, we return -1, as the amount cannot be generated with the given coins.
# 5. If the value at the last row and last column is not infinity, we return the value.

from typing import List
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # Initialize the 2D array with rows as the number of coins and columns as the amount
        ROWS, COLS = len(coins)+1, amount+1
        dp = [[0 for _ in range(COLS)]for _ in range(ROWS)]
        # Initialize the first row with infinity
        for i in range(1, COLS):
            dp[0][i] = float('inf')
        
        # Iterate through the array and fill the values
        for i in range(1, ROWS):
            for j in range(1, COLS):
                # If the amount is less than the coin value, take the value from the previous row
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                # If the amount is greater than or equal to the coin value, take the minimum of the value from the previous row and 1 + the value at the same row and the column - coin value
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j-coins[i-1]])
        
        # If the value at the last row and last column is not infinity, return the value
        if dp[ROWS-1][COLS-1] != float('inf'):
            return dp[ROWS-1][COLS-1]
        # If the value at the last row and last column is infinity, return -1
        else:
            return -1

# Approach: Space optimized DP
# Using a 1D array to store the values of the dp array, instead of a 2D array.
# Space Complexity : O(m) where m is the amount
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # now let's do the DP approach
        ROWS, COLS = len(coins)+1, amount+1
        dp = [0 for _ in range(COLS)]
        for i in range(1, COLS):
            dp[i] = float('inf')
        
        for i in range(1, ROWS):
            for j in range(1, COLS):
                if j >= coins[i-1]:
                    dp[j] = min(dp[j], 1 + dp[j-coins[i-1]])
        
        if dp[COLS-1] != float('inf'):
            return dp[COLS-1]
        else:
            return -1

# Time Complexity : O(2^(n+m)) where n is the number of coins and m is the amount
# Space Complexity : O(n+m) where n is the number of coins and m is the amount

# Approach: Recursive approach or exhaustive search
# 1. We recursively select the coins and check if the amount can be generated.
# 2. We have two choices at each step:
#     a. Choose the coin: We decrement the amount by the coin value and increment the count.
#     b. Do not choose the coin: We move to the next coin.
# 3. We return the minimum of the two choices.
# 4. If the amount is less than 0 or we have exhausted all the coins, we return infinity.
# 5. If the amount is 0, we return the count.
# 6. If the result is infinity, we return -1.
# 7. If the result is not infinity, we return the result.

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # let's code up the recursive approach
        def selectCoins(amount, i, count):
            # base case
            if amount < 0 or i == len(coins):
                return float('inf')
            if amount == 0:
                return count
            # case1: choose the coin
            choose = selectCoins(amount-coins[i], i, count+1)
            # case2: do not choose the coin
            notChoose = selectCoins(amount, i+1, count)
            # return the minimum of the two choices
            return min(choose, notChoose)

        res = selectCoins(amount, 0, 0)
        if res == float('inf'):
            return -1
        else:
            return res