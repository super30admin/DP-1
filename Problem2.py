#Time Complexity - O(n)
#Space Complexity - O(n)

class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [0] * len(nums)
        
        for i in range(len(nums)):
            if i - 1 < 0 or i -2 < 0:
                dp[i] = nums[i] if i - 1 < 0 else max(nums[i], dp[0])
                continue
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        
        return dp[len(nums) - 1]