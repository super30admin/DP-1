#
# Time Complexity = O(2^n)
# Space Complexity = O(n)
# Works on leetcode
#

class Solution:
    def rob(self, nums: List[int]) -> int:
        def helper(index):
            if index >= len(nums):
                return 0
            if index == len(nums)-1:
                return nums[-1]
            else:
                cm = max(nums[index]+helper(index+2), helper(index+1))
                return cm
        return helper(0)
