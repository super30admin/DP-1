class RecursiveSolution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        return self.helper(nums, 0, 0)

    def helper(self, nums, idx, currSum):
        if idx >= len(nums):
            return currSum

        return max(self.helper(nums, idx + 2, currSum + nums[idx]),
                   self.helper(nums, idx + 1, currSum))


class DPSolution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return max(nums)

        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        return dp[-1]