# Time Complexity : O(n), where n is the number of houses
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        nums[1] = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            nums[i] = max(nums[i - 1], nums[i - 2] + nums[i])

        return nums[-1]
