class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        dp = [nums[0],nums[1]]
        for i in range(2,len(nums)):
            if i-3 >= 0:
                dp.append(nums[i] + max(dp[i-2],dp[i-3]))
            else:
                dp.append(nums[i] + dp[i-2])
        return max(dp[-1],dp[-2])
