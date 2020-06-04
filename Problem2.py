"""
// Time Complexity : o(n), where n is the number of houses
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
"""



class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        
        dp = [0]*(len(nums)+2) #creat dp array of size 2 more than length of nums
        
        for i in range(2,len(nums)+2):
            dp[i] = max(dp[i-1], nums[i-2] + dp[i-2] ) #keeps track of max at each instance
        return dp[-1] #last value is the result