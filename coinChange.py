# Leetcode 322. Coin Change

# Time Complexity :  O(nT) where n is the size of the array and T is the amount

# Space Complexity : O(nT) where n is the size of the array and T is the amount

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Find the optimal solution for each sub problem and combine them. Create a matrix with coins as the rows
# and amount as colums both starting at zero. As we need to choose the maximum value from previous case initialize the
# first row to a max_value and first column to zero. In nested for loop if the current amount is less than the
# previous coin value keep using the previous coin value else use the coin and the number of coins for the balance.
# Find the maximum of previous value and the new sum found in previous step.
# Return the last cell in matrix as long as the solution exists, else return -1

# Your code here along with comments explaining your approach

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        matrix = [[0 for x in range(amount+1)] for y in range(len(coins)+1)]

        max_val = amount + 1

        # Adding zero in the first column
        for row in range(len(coins)+1):
            matrix[row][0] = 0

        # Adding max_val in first row
        for col in range(1, amount+1):
            matrix[0][col] = max_val

        for row in range(1, len(coins)+1):
            for col in range(1, amount+1):
                # If the amount is less than previous coin use previous value
                if (col < coins[row-1]):
                    matrix[row][col] = matrix[row-1][col]
                else:
                    bal = col-coins[row-1]
                    matrix[row][col] = min(
                        matrix[row-1][col], 1 + matrix[row][bal])

        result = matrix[len(coins)][amount]

        return (result if result < max_val else -1)
