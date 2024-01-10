# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def rob(self, nums: List[int]) -> int:
      dp = [0 for _ in range(len(nums))]

      for i in range(len(nums)):
        if i == 0:
          dp[i] = nums[i]
        else:
          dp[i] = max(
            nums[i] + dp[i - 2], # Rob current + 2 house back
            dp[i - 1] # Not rob current => rob previous house
          )
      return dp[-1]
        
