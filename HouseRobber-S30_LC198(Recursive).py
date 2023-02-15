# Recursive/Exhaustive
# TLE
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums==None or len(nums)==0:
            return 0

        return self.helper(nums, 0, 0)

    def helper(self, nums, index, amount):
        #base. >= because in one case we increment index by 2.
        if index>=len(nums):
            return amount

        #logic
        # zero case or do not rob case
        case0 = self.helper(nums, index+1, amount)

        # one case or rob case. index+2 as adjacent houses cannot be robbed.
        case1 = self.helper(nums, index+2, amount+nums[index])

        return max(case0, case1)