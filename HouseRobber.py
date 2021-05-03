# TC: O(N) where N is the length of the input array. 
# SC: O(N) to store the DP array for storing calculated values.

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0 
        
        dp = [0] * (len(nums) + 1)
        
        for i in range(1,len(nums)+ 1):
            if i == 1:
                dp[i] = nums[i - 1]
            else:
                dp[i] = max(dp[i - 1], (nums[i - 1] + dp[i - 2]))
        
        return dp[-1]
