# Dynamic Programing approach
# Time complexity is O(n)
# We will improve upon the space complexity of the previous DP approach. We will reduce the size of our dp array from 2D to 1D
# At any given point we just need the values at the previous step so we dont need to maintain all the values before that.
# This will reduce the Space complexity to O(1) i.e constant

class Solution:
    def rob(self, nums: List[int]) -> int:
        pick,skip = 0,nums[0]
        for i in range(1,len(nums)):
            temp_arr_0 = pick
            pick = max(pick,skip)
            skip = temp_arr_0 + nums[i]
        return max(pick, skip)
