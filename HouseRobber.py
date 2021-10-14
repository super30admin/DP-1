"""
Time Complexity: O(n)
Space Complexity: O(1)
"""

class Solution:
    def rob(self, nums: List[int]) -> int:
        # dp_array = [[None] * 2 for _ in range(len(nums))]
        skip = 0
        take = nums[0]
        # dp_array[0][0] = 0
        # dp_array[0][1] = nums[0]

        for i in range(1, len(nums)):
            # skip
            temp = skip
            skip = max(skip, take)
            # don't skip
            take = nums[i] + temp

        return max(skip, take)