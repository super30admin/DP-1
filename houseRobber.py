#TimeComplexity:O(N) 
#SpaceComplexity: 
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==0:
            return 0
        i,j,temp=nums[0],0,0
        for k in range(1,len(nums)):
            temp=i
            i=j+nums[k]
            j=max(temp,j)
        return max(i,j)
