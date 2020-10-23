"""
This is the recursive code as of now which I wrote, will be modifying it to DP and submitting again
once I understand how DP can be handled here. For now it gives me time limit exceeded. Thanks
"""


class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        return self.helper(nums, 0, 0)

    def helper(self, nums, idx, maxsum):
        if idx >= len(nums):
            return maxsum
        case1 = self.helper(nums, idx+2, maxsum+nums[idx])
        case2 = self.helper(nums, idx+1, maxsum)
        return max(case1, case2)
