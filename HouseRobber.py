# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


class Solution:
    def rob(self, nums: List[int]) -> int:
        prevMax = 0
        currentMax = 0
        for i in range(len(nums)):
            temp = currentMax
            currentMax = max(nums[i] + prevMax, currentMax)
            prevMax = temp
        return currentMax