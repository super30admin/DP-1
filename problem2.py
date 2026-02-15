## Problem2 (https://leetcode.com/problems/house-robber/)

class Solution:

    def rob(self, nums: List[int]) -> int:
        n= len(nums)
        if n == 1:
            return nums[0]
        final_arr = [0]*n
        final_arr[0] = nums[0]
        final_arr[1] = max(nums[0],nums[1])
        for i in range(2,n):
            final_arr[i] = max((final_arr[i-1]),(nums[i]+final_arr[i-2]))
        return final_arr[-1]