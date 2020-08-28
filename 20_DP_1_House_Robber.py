#Time Complexity : O(N) where N is the numbers present in the list
#Space Complexity : O(N) for using one extra array to store the max value every time
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Need to go through the solution, then got the idea. The idea is still taking time for me for Dynamic Programming questions


#Your code here along with comments explaining your approach

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==0: 
            return 0 
        if len(nums)==1: 
            return nums[0]
        if len(nums)==2: 
            return max(nums[0], nums[1])
        
        dp=[float('-inf')]*(len(nums)+1) 
        
        dp[0]=nums[0]
        dp[1]=max(nums[0],nums[1])
        for i in range(2,len(nums)): 
            dp[i]=max(nums[i]+dp[i-2],dp[i-1])
        return dp[len(nums)-1]    