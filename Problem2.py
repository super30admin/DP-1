# Time Complexity : O(n) whewre m is the amount and n is the len of the array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#Approach: 1. We check the base case where we have only 2 elements and return the max.
#          2. We initiate two pointers, prev which is 2 index behind and curr which is one index behind. We take the max of skipping and taking the current index value at each step.
#          3. Since each step considers the adjacent index take/skip. By the end we will have a global max through a valid path.

class Solution:
    def rob(self, nums: list[int]) -> int:
        n = len(nums)
        if n <= 2:
            return max(nums)
        
        prev, curr = nums[0], max(nums[0], nums[1])

        for i in range(2, n):
            prev, curr = curr, max(curr, prev + nums[i])
        return curr