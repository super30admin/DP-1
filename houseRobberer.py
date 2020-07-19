# Time Complexity O(n) where n is the length of Houses
# Space Complexity O(n)

import sys
class Solution(object):
    def rob(self, nums):
        if not nums:
            return 0
        d = [[None, None]] * len(nums)
        d[0] = [0, nums[0]]
        for i in range(1, len(nums)):
            d[i] = [max(d[i-1][0], d[i-1][1]), (nums[i] + d[i-1][0])]

        return max(d[len(nums)-1][0],d[len(nums)-1][1])





        """
        :type nums: List[int]
        :rtype: int
        """
