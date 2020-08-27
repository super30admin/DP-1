class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        C = 0
        DC = 0
        
        for i in range(0, len(nums)):
            temp = DC
            DC = max(C, DC)
            
            C = temp + nums[i]
        return max(C, DC)
