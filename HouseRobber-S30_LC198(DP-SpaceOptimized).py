# DP
# Important pattern
# Submitted successfully
# Space Optimized, SC = O(1)
# TC = O(n) where n = len(nums)
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == None or len(nums) == 0:
            return 0

        skip = 0  # do not rob or 0 case
        take = nums[0]  # rob or 1 case

        for i in range(1, len(nums)):
            temp = skip

            # do not rob or 0 case
            skip = max(skip, take)

            # rob or 1 case
            take = temp + nums[i]

        return max(skip, take)