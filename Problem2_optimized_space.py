class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if(nums==None or len(nums)==0): return 0
        if(len(nums)==1):
            return nums[0]
        n = len(nums)
        prev = nums[0]
        cur = max(nums[0], nums[1])
        for i in range(2, n):
            temp = cur
            cur = max(cur, nums[i] + prev)
            prev = temp
            #two options not choose and choose with nums[i]
        return cur