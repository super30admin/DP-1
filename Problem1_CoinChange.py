# Time Complexity: O(mn), where m - no of coin denominations, n - amount
# Space Complexity: O(mn)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Solution:

class Solution:
    def coin_change(self, coins: List[int], amount: int) -> int:
        if not coins or len(coins) == 0:
            return -1

        # Initialize a 2D array with coin denominations as rows and amount as columns.
        rows, cols = len(coins) + 1, amount + 1
        dp = [[0] * cols] * rows

        # Initialize first row with maximum value
        for j in range(1, cols):
            dp[0][j] = amount + 1

        # Fill the remaining values of the array with the min number of coins required for every amount.
        for i in range(1, rows):
            for j in range(1, cols):
                if coins[i - 1] > j:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1)

        # If the final value in the array is still the maximum value initialized, then no coins can make up the amount.
        if dp[rows - 1][cols - 1] == amount + 1:
            return -1

        # Else, return the minimum number of coins.
        return dp[rows - 1][cols - 1]

