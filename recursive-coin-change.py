##**RECURSIVE APPROACH**##
# Time Complexity - Exponential O(2^n) where n = amount
# Space Complexity - O(n)
# Did this run on Leetcode - No, TLE
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

# Here is the recursive solution...

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        def helper(amt):
            # Backtrack
            if amt < 0:
                return -1

            # Base Case
            if amt == 0:
                return 0
            minval = float('inf')

            # Recursive Case
            for c in coins:
                res = helper(amt - c)
                if res >= 0 and res < min:
                    minval = res + 1

            return minval if minval != float('inf') else -1

        return helper(amount)
