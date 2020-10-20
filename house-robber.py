# Time Complexity - O(n) where n = amount
# Space Complexity - O(n)
# Did this run on Leetcode - Yes
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
# - We can build a 1D dp table to hold solutions to all subproblems and populate it following the recurrance.

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]

        # Initialize Table
        table = [None]*(len(nums)+1)

        # Base Case
        # Every entry in table - max amount of money you can rob from n houses
        table[0] = 0  # 0 houses, 0 money
        table[1] = nums[0]  # 1 house, money from first house
        table[2] = max(nums[0], nums[1])  # Cannot rob two adjacent houses

        # Fill table
        # If the. last house is robbed, max profit is f(i-2)+nums[i]
        # If the last house is not robbed the max profit is f(i-1)
        for i in range(3, len(nums)+1):
            table[i] = max(table[i-1], table[i-2] + nums[i-1])
        return table[-1]
