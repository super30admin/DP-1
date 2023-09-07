class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        t1 = 0
        t2 = 0
        for i in range(len(nums)):
            temp = t1
            t1 = max(nums[i]+t2, t1)
            t2 = temp
        
        return t1

# TC: O(n)
# Sc: O(1)