# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No, since the explanation from class was clear.


# Your code here along with comments explaining your approach
# Dynamic Programming approach from class, where we use skip and take to take solution
# from the sub problems and use to solve bigger problems

class Solution:
    def rob(self, nums: List[int]) -> int:
        skip, take = 0, 0
        for i in range(len(nums)):
            temp = skip
            skip = max(skip, take)
            take = nums[i] + temp
        return max(skip, take)