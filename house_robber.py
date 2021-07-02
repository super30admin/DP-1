#Time Complexity :  O(N)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        if len(nums)==0:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0],nums[1])
        
        dp = [float('inf') for i in range(0,len(nums)+1)]
        dp[0] = 0
        dp[1] = nums[0]
        for i in range(2,len(nums)+1):
            dp[i] = max(nums[i-1]+dp[i-2],dp[i-1])
        print(dp)
        return dp[len(nums)]