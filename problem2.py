# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        dpMap = [[0,0] for _ in range(len(nums))]
        dpMap[0][1] = nums[0]
        for i in range(1, len(nums)):
            dpMap[i][0] = max(dpMap[i-1])
            dpMap[i][1] = dpMap[i-1][0]+nums[i]
            
        return max(dpMap[len(nums)-1])