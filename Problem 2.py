## Problem2 (https://leetcode.com/problems/house-robber/)


# Time Complexity : O(n)
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        d=[[None for i in range(2)] for j in range(len(nums))]

        d[0][0]=0
        d[0][1]=nums[0]
        print(d)
        for i in range(1,len(nums)):
            d[i][0]= max(d[i-1][0],d[i-1][1])
            d[i][1]= nums[i]+d[i-1][0]
        return max(d[len(nums)-1][0], d[len(nums)-1][1])
        


        