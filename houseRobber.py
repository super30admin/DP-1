class Solution(object):

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dp = [[None for j in range(2)] for r in range(len(nums)+1)]
        
        dp[0][0] = 0
        dp[0][1] = 0
        
        for i in range(1, len(nums)+1):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            dp[i][1] = nums[i-1] + dp[i-1][0]
        
        return max(dp[len(nums)][0],dp[len(nums)][1])

      # Time Complexity = 0(n)
      # Space Complexity = 0(2n)
