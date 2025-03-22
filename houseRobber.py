# to reduce space complexity by removing dp table
# TC: O(n) going through row in linear manner
# SC: O(1) removed dp table
from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0

        n = len(nums)
        # dp array is removed
        skip = 0
        take = nums[0]

        for i in range(1, n):
            # Not choose
            temp = skip
            skip = max(skip, take)
            # Choose
            take = temp + nums[i]

        return max(skip, take)

    # # Using DP table to avoid repeated subproblems
    # TC: O(n) going through row in linear manner


# SC: O(n)  dp table
# def rob(self, nums: List[int]) -> int:
#     if nums is None or len(nums) == 0:
#         return 0

#     n = len(nums)
#     dp = [[0] * 2 for _ in range(n)]

#     dp[0][1] = nums[0]

#     for i in range(1, n):
#         # Not choose
#         dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
#         # Choose
#         dp[i][1] = dp[i - 1][0] + nums[i]

#     return max(dp[n - 1][0], dp[n - 1][1])

# # Recursion:
# # def rob(self, nums: List[int]) -> int:
# #     if not nums:
# #         return 0
# #     return self.helper(nums, 0, 0)

# # def helper(self, nums, index, robbed_amount):
# #     # Base case
# #     if index >= len(nums):
# #         return robbed_amount

# #     # Do not rob case (skip current house)
# #     case1 = self.helper(nums, index + 1, robbed_amount)

# #     # Rob case (rob current house and move to the next non-adjacent house)
# #     case2 = self.helper(nums, index + 2, robbed_amount + nums[index])

# #     return max(case1, case2)
