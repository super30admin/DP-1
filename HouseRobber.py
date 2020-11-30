# Time Complexity : O(N)

# Space Complexity : O(1)

# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# In this DP solution I have used two variable skip an take which indicate i select a house or not.
# I go on updating these variables and return the maximum of them.

class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0

        skip, take = 0, nums[0]
        for i in range(1, len(nums)):
            temp = max(skip, take)
            take = skip + nums[i]
            skip = temp

        return max(skip, take)





