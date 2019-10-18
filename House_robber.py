#Time complexity: O(n)
#space complexity O(n)
#Leetcode submission: successful
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        
        """
        #if nums is empty then return 0
        if (len(nums)==0):
            return 0
        #if nums has only 1 element return that element
        if (len(nums)==1):
            return nums[0]
            
        #array for the final values
        value=[0]*(len(nums))
        value[0]=nums[0]
        value[1]=max(nums[0],nums[1])
        for i in range(2,len(nums)):
            value[i]=max(nums[i]+value[i-2],value[i-1])
        return value[len(nums)-1]
    