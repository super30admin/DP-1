class Solution:
    def rob(self, nums: List[int]) -> int:
        # total = self.robRecursive(nums, 0)
        total = self.robdp(nums)
        return total
    
    def robdp(self, nums):
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        dp = [0]*len(nums)
        dp[0] = nums[0]
        dp[1] = max(dp[0], nums[1])
        for i in range(2, len(nums)):
            dp[i] = max(nums[i]+ dp[i-2], dp[i-1])
        return dp[-1]

    def robRecursive(self, nums, idx):
        if idx >= len(nums):
            return 0
        
        chose = nums[idx] + self.robRecursive(nums, idx+2)
        nochose = self.robRecursive(nums, idx+1)
        return max(chose, nochose)

