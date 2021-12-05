"""
Time Complexity : O(n) for traversing the array once
Space Complexity : O(n) for storing the dp values
"""
class Solution:
    def rob(self, nums) -> int:
        # If nums doesn't exist
        if not nums:
            return 0

        # If the length of nums is one, then return that element
        if len(nums) == 1:
            return nums[0]

        # Creating a dp array
        dp = [0] * len(nums)

        # Initializing first and second elements
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            # Max of (selecting the current element, not selecting the current element)
            dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])

        # Return the last element
        return dp[-1]