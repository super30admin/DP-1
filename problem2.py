# Time Complexity : O(n)
# Space Complexity: O(n)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def rob(self, nums: List[int]) -> int:
        Sum = 0
        robbedVar = nums[0]
        notRobbedVar = 0

        for i in range(1, len(nums)):
            temp = notRobbedVar
            notRobbedVar = max(notRobbedVar, robbedVar)
            robbedVar = nums[i] + temp

        return max(robbedVar, notRobbedVar)

