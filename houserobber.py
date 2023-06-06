# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to solve the problem by finding the max value of the robbery in each nested levels and store it and then return.

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if(len(nums)==1):
            return nums[0]
        prev=nums[0]
        curr=max(nums[0],nums[1])
        for i in range(2,len(nums)):
            temp=curr
            curr=max(curr,nums[i]+prev)
            prev=temp
        return curr