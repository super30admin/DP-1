class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==0 : return 0
        if len(nums)==1 : return nums[-1]
        else:
            if nums[1]<nums[0]:
                nums[1]=nums[0]
           
            for i in range(2,len(nums)):
                if nums[i]+nums[i-2]>nums[i-1]:
                    nums[i]+=nums[i-2]
                else:
                    nums[i]=nums[i-1]
            return nums[-1]