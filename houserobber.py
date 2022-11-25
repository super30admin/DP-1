## Problem2 (https://leetcode.com/problems/house-robber/)
# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no 
# Code Explaination:
# 1. I am trying to backtrace from the 3rd element from the last, it has only one choice : to choose the last element
# 2. Now the last 4th number should only worry about the 2nd last and 1st last and add on the maximum out of it.
# 3. this way the whole nums are parsed to obtain the maximum looted element 
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n==1:
            return nums[0]
        if n==2:
            return max(nums)
        nums[-3] = nums[-3] + nums[-1]
        if n==3:
            return max(nums)
        for i in range(n-4, -1, -1):
            # print(i)
            nums[i] = nums[i] + max(nums[i+2], nums[i+3])
        return max(nums[0],nums[1])
            
        # # print(nums)
        # dupe = nums[::]
        # # print(dupe)
        # for i in range(len(nums)-3, -1, -1):
        #     dupe[i] = dupe[i] + max(dupe[i+2:])
        # # print(dupe)
        # return max(dupe)
            
        