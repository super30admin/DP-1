# time complexity : 0(n)
# space complexity : 0(n)

class Solution(object):
    def rob(self, nums):
        
        n = len(nums)
        if n == 0:
            return 0
        
        if n == 1:
            return nums[0]
        
        
        dp = [0]*n
        
        dp[0] = nums[0]
        dp[1] = max(nums[0],nums[1])
        
        for index in range(2,n):
            dp[index] = max(nums[index] + dp[index-2] , dp[index-1] )
            
        return dp[n-1]
        """
        :type nums: List[int]
        :rtype: int
        """
        