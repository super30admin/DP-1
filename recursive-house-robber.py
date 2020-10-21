##**RECURSIVE APPROACH**#
# Time Complexity - O(2^n)
# Space Complexity - O(n)
# Did this run on Leetcode - No, TLE
# Did you face any problems - No
# Approach & Intuition
# Try to decrease and conquer the problem:
# - Define an objective function f(i) = maximum amount of money you can rob from the first i houses
# - At the ith house, the robber can make 1 of 2 choices - Rob the last house or not rob the last house
# - This leads to the following recurrence equation: f(i) = max(f(i-1), f(i-2) + nums[i])
# - The recurrence tree for this would look similar to the recurrance for the fibonacci series
# where the solution to the current problem depends on the previous two subproblem solutions
# - Recursion would lead to a combinatorial explosion O(2^n) of options (at every level inclde the current house and consult the solution for the i-2th subproblem or exclude the current house and consult the solution for i-1th subproblem)
# - There are multiple repeating subproblems here which makes it a good candidate for DP

# Here's the recursive approach...

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        def helper(i):
            # Base
            if i < 0:
                return 0
            if i == 0:
                return nums[0]
            return max(helper(i-1), helper(i-2) + nums[i])

        return helper(len(nums)-1)
