# Time Complexity: O(n), where n is length of input array
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Solution:

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0

        skip, rob = 0, nums[0]

        # For every house, compute the amount for 2 cases - rob & skip
        for i in range(1, len(nums)):

            # case1: skip -> max amount robbed including previous house
            temp = skip
            skip = max(skip, rob)

            # case2: rob -> amount in the house + max amount robbed excluding previous house
            rob = nums[i] + temp

        return max(skip, rob)