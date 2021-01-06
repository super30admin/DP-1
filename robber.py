# Time Complexity : O(n) - n: Number of houses
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this : 


class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == None or len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        
        dp = [nums[0], max(nums[0], nums[1])]
        
        for i in range(2, len(nums)):
            dp.append(max(dp[i-2] + nums[i], dp[i-1]))
            
        return dp[-1]
