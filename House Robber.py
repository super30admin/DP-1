# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
  def rob(self, nums: List[int]) -> int:
    dp = list()
    if len(nums) == 1:            
      return nums[0]
    elif len(nums) == 2:            
      return max(nums[1], nums[0])        
    
    dp = [0] * len(nums)
    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])        
    for i in range(2, len(nums)):
      dp[i] = max(dp[i-1], nums[i] + dp[i-2])
    return dp[len(nums)-1]
            