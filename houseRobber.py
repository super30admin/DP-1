# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : y
# Any problem you faced while coding this : n


# Your code here along with comments explaining your approach

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        if not nums:
            return 0
        
        if len(nums) == 1:
            return nums[0]
        
        choose = nums[0]
        skip = 0
        
        
        for i in range(1, len(nums)):
            prevSkip = skip
            skip = max(skip, choose)
            choose = prevSkip + nums[i]
            
            
        return max(skip, choose)

# iterating through the start of the array (from i = 0). if we have chosen a value, we wont choose it in the next iteration
# at i=1, pickinh max of choose and dont choose from i=0 and choose = prevSkip + nums[i]