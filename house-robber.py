# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)

        if n == 0:
            return 0
        if n == 1:
            return nums[0]

        # dp[i] will store the maximum amount robbed up to house i
        dp = [0] * n

        # Base Cases
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1]) # Either rob house 0 or house 1

        # Fill the DP table using the recurrence relation
        for i in range(2, n):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])

        return dp[n-1]