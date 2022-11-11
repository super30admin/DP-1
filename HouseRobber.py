#Time Complexity : O(n)
#Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : No
# Approach: We can rob any house but they should not be adjacent. We need to optimize it to the maximum. 
# So we will approach this problem using Dynamic Programming
# Step 1: Keep the first two as it is 
# Step 2: From the third onwards, find the maximum element from 0 to (i -2) second last elemet
# Step 3: Add with the current position 

from typing import List
class Solution:
    def getMax(self,nums):
        return max(nums)
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        for i in range(2, len(nums)):
            nums[i] = self.getMax(nums[:i - 1]) + nums[i]
        return max(nums[-1], nums[-2])