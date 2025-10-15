class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if(nums==None or len(nums)==0): return 0
        if(len(nums)==1):
            return nums[0]
        return self.helper(nums, 0)

    def helper(self, nums, idx):
        #base
        if(idx >= len(nums)):
            return 0
        #logic
        case1 = self.helper(nums, idx+1)
        case2 = nums[idx] + self.helper(nums, idx+2)
        return max(case1, case2)