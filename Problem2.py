'''
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced


Your code here along with comments explaining your approach:

We are traversing the array once and trying to find, at every position what is possible highest possible loot.
This is being done keeping in mind the condition, alternate houses cannot be robbed
'''

class Solution:
    def rob(self, nums: List[int]) -> int:

        for i in range(1,len(nums)):
            if i == 1:
                nums[1] = max(nums[0],nums[1])
                continue

            nums[i] = max(nums[i]+nums[i-2], nums[i-1])

        return nums[-1]