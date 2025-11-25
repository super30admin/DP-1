# Take 2 variables, prev2 and prev where prev2 is the first elememt and prev is the max between 
# the first and the second element for each remaining elements in nums, check the max between
#  prev2+current element and prev elememt, the max is the current element. Prev2 becomes prev1 
#  and prev1 becomes current, updat the new current

#  Time complexity: O(n)
#  Space complexity: O(1)




class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l=len(nums)
        if l==1:
            return nums[0]
        if l==2:
            return max(nums[0],nums[1])
        prev2=nums[0]
        prev1=max(nums[1],nums[0])
        for i in range(2,l):
            current = max(prev1,prev2+nums[i])
            prev2=prev1
            prev1=current
        return current

        