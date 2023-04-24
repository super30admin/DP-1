"""
TC=O(N) and SC=O(1)
using only 2 variables because we have only 1 variable dependency i.e nums. 
// Did this code successfully run on Leetcode : Yes
"""

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        notChosenProfit = 0
        chosenProfit = nums[0]
        for i in range(1, len(nums)):
            temp = notChosenProfit
            notChosenProfit = max(chosenProfit, notChosenProfit)
            chosenProfit = temp + nums[i]
        return max(notChosenProfit, chosenProfit)