"""
Time: O(n)
Space: O(n)
Leet: Accepted
Problems: Difficulty in grasping the for loop to update
memo
"""

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0

        memo = [-1] * (len(nums)+1)
        memo[0] = 0
        memo[1] = nums[0]

        for i in range(1,len(nums)):
            val = nums[i]
            memo[i+1] = max(memo[i],memo[i-1]+val)

        return memo[-1]
