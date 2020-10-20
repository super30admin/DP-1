# Time Complexity - O(n) where n = amount
# Space Complexity - O(n)
# Did this run on Leetcode - Yes
# Did you face any problems - No
# Approach & Intuition
# Try to decrease and conquer the problem:
# - Define an objective function f(i) = minimum amount of coins to make amount i
# - For any arbitrary amount i, we can compute f(i) using the min of the previous solutions + 1
# - For instance - given coin denominations 1,2,5 and amount 11
# - We can get 11 using min(f(11-1), f(11-2), f(11-5)) + 1
# - This leads to the following recurrence equation: f(i) = min(f(i-ck))+1 ∀ c ∈ coins
# - If we construction the recurrence tree for this on the given example
# - f(11) depends on f(10), f(9), f(6)
#     - f(10) depends on f(9), f(8), f(5)
#     - f(9) depends on f(8), f(7), f(4)
#     - f(6) depends on f(5), f(4), f(1)
#         - f(9) depends on f(8), f(7), f(4)
#         ...
# - There are multiple repeating subproblems here which makes it a good candidate for DP
# - We can build a 1D dp table to hold solutions to all subproblems and populate it following the recurrance.

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # Initialize 1D array of size amount
        table = [float('+inf')]*(amount+1)

        # Base Cases
        table[0] = 0

        # Tabulation
        for i in range(1, amount+1):
            minval = float('+inf')
            # For every coin denomination available
            # If it is >= 0, lookup it's values, find the min
            for c in coins:
                if i - c >= 0:
                    minval = min(table[i-c], minval)
            # Add the min + 1 (including the last coin) to fill the table
            table[i] = minval + 1

        return table[-1] if table[-1] != float('+inf') else -1
