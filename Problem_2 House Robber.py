# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach


class Solution:
    def rob(self, nums: List[int]) -> int:
        skip = 0
        take = nums[0]

        for i in range(1, len(nums)):
            temp = skip
            # Case 0
            skip = max(skip, take)
            # Case1
            take = temp + nums[i]
        return max(skip, take)
