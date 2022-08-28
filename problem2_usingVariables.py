"""
Time Complexity: O(n)  where n is number of houses
Space Complexity: O(1) 

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:

Instead of using an array to solve this question, we can solve this usking two variables as we need to reference only previous value and not all the values.
This will improve the space complexity.
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        skip = 0
        take = nums[0]
        
        for i in range(1, len(nums)):
            tempSkip = skip
            skip = max(skip, take)
            take = tempSkip + nums[i]
        
        return max(skip, take)
        