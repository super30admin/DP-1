# Created by Aashish Adhikari at 6:44 PM 1/5/2021

'''
Time Complexity:
O( 2 ^ length of nums)

Space Complexity:
O(2 ^ length of nums)

'''

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        return self.helper(nums, 0, 0)

    def helper(self, nums, index, amount):

        # base case
        if index >= len(nums): # include > as well since we are doing index+2 in case 2.
            return amount

        # dont choose the house
        case1 = self.helper(nums, index+1, amount)

        # choose the house
        case2 = self.helper(nums, index+2, amount + nums[index])

        return max(case1, case2)
