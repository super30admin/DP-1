"""
TC: O(n)
SC: O(n)
"""

1class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 3:
            return max(nums)
            
        res = [i for i in nums]
        res[1] = max(res[0], res[1])
        for i in range(2, len(nums)):
            res[i] = max(res[i-1] , res[i-2] + nums[i])
        
        return res[-1]
    
