class Solution(object):
    def rob(self, nums):
        """
        Time complexity: O(n)
        Space complexity: O(n)
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n < 2:
            return nums[0]

        # Initialize dp list with 0 values
        dp = [0] * n

        # Base cases
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        # Calculate maximum rob amount for each house
        for i in range(2, n):
            # Choose the maximum amount between robbing the current house and not robbing it
            dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])

        return dp[n - 1]
