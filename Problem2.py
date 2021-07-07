#
# Time Complexity = O(n) 
# Space Complexity = O(n)
# Works on leetcode
#
class Solution:
    def rob(self, nums: List[int]) -> int:
        h = {}

        def helper(index):
            if index in h:
                return h[index]
            if index >= len(nums):
                return 0
            if index == len(nums)-1:
                return nums[-1]
            else:
                cm = max(nums[index]+helper(index+2), helper(index+1))
                h[index] = cm
                return cm
        return helper(0)
