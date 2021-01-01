#Time Complexity :O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : tried running sum.
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        lenght=len(nums)
        if(nums==None or lenght==0):
            return 0
        
        if(lenght==1):
            return nums[0]
        
        rtotal=[nums[0],max(nums[0],nums[1])]
        
        for i in range(2,lenght):
            maxi=max(nums[i]+rtotal[i-2],rtotal[i-1])
            rtotal.append(maxi)
        
        return (rtotal[lenght-1])
        
        