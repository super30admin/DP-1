# Track the max amount robbed up to each house.
# At each house choose the max of (rob current + dp[i-2]) or (skip current and take dp[i-1]).
# Use a rolling window (prev, curr) to optimize space.

# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]

        prev, curr = 0, 0
        for num in nums:
            prev, curr = curr, max(curr, prev + num)
        return curr