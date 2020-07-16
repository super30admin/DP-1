class HouseRobber(object):
    '''
    Solution:
    1. Problem can be solved using recursion and has overlapping subproblems and so use dynamic programming. Recursive
        step would be based on whether the robber visits the current house or not.
    2. The main logic is that if the robber visits the house, add the previous' previous max value otherwise take previous
        max value, compare these two values and update the max value at the current position (house).
    3. Overlapping subproblems example -- [1, 2, 3, 1] in this array, the subproblem [3, 1] is computed more than once.

    --- Passed all testcases on Leetcode successfully
    '''
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # O(n) Time Complexity | O(1) Space Complexity
        if (nums == None or len(nums) <= 0):
            return 0

        prevMax = 0
        currMax = nums[0]

        for i in range(1, len(nums)):
            newMax = max(prevMax + nums[i], currMax)
            prevMax = currMax
            currMax = newMax

        return currMax
