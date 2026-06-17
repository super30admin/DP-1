# LEETCODE PROBLEM 198. HOUSE ROBBER
# TIME COMPLEXITY: O(N) where N denotes the number of elements in an array
# SPACE COMPLEXITY: O(1) 
# Any problem you faced while coding this: None


class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 1:
            return nums[0]
        
        prev = nums[0]
        current= max(nums[0], nums[1])
        for i in range(2,len(nums)):
            temp=current
            current=max(temp,prev+nums[i])
            prev=temp
        return current