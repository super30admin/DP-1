# Time Complexity: O(N), N = number of elements in nums array
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes

# Your code here along with comments explaining your approach
# I have used bottom up tabulation method with two variables

from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        prev = nums[0]
        current = max(prev, nums[1])

        for index in range(2, len(nums)):
            temp = current
            current = max(current, nums[index] + prev)
            prev = temp
        
        return current
