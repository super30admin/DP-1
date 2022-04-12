from typing import List

"""
Time complexity is O(n) and space complexity is O(1)
"""

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0

        skip = 0
        take = nums[0]

        for i in range(1, len(nums)):
            temp = skip
            skip = max(skip, take)
            take = temp + nums[i]

        return max(skip, take)
