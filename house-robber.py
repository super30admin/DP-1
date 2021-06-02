# Reference Video: https://youtu.be/xlvhyfcoQa4
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
        dp=[0 for i in range(len(nums))]
        dp[0] = nums[0]
        dp[1] = max(nums[1],nums[0])
        for i in range(2, len(dp)):
            dp[i] = max (nums[i]+dp[i-2],dp[i-1])
        return dp[len(dp)-1]
            