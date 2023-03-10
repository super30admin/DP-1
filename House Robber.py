# Time Complexity :  O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        for i in range(len(nums)-1,-1,-1):
            if i + 3 < len(nums) and i + 2 < len(nums):
                nums[i] += max(nums[i+2], nums[i+3])
            elif i + 2 < len(nums):
                nums[i] += nums[i+2]
        return max(nums[i],nums[i+1])
        
