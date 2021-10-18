# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: ✔️
# Any problem you faced while coding this: Not sure if this is the most efficient solution
from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        max_robbed_amount = [None for _ in range(len(nums) + 1)]
        N = len(nums)
        max_robbed_amount[N], max_robbed_amount[N - 1] = 0, nums[N - 1]
        for i in range(N - 2, -1, -1):
            max_robbed_amount[i] = max(max_robbed_amount[i + 1], max_robbed_amount[i + 2] + nums[i])
        return max_robbed_amount[0]
