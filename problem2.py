#house-robber
from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]

        dp_arr = [0] * len(nums)
        dp_arr[0] = nums[0]
        dp_arr[1] = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            dp_arr[i] = max(dp_arr[i - 1], dp_arr[i - 2] + nums[i])

        return dp_arr[-1]
