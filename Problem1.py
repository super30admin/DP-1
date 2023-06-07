class Solution:
    def rob(self, nums: List[int]) -> int:
        length_of_array = len(nums)
        if length_of_array == 1:
            return nums[0]
        if length_of_array == 2:
            return max(nums[0], nums[1])

        dp = [0] * length_of_array
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, length_of_array):
            dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])

        return dp[-1]