        """
        Time complexity : O(n)
        space complexity : O(n)
        
        Did this code successfully run on Leetcode : Yes
        Any problem you faced while coding this : No
        """
 #using bootom up of the  dynamic program by the taking array of cost of house


class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) == 0: return 0
        n = len(nums)
        if n == 1: return nums[0]
        dp = [0 for _ in range(n)]
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            dp[i] = max(dp[i-1], nums[i] + dp[i - 2])
            
            
        return dp[n-1]