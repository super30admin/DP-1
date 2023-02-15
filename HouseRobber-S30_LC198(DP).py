# DP
# Important pattern
# Submitted successfully
# TC = SC = O(n) where n = len(nums)
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums==None or len(nums)==0:
            return 0

        # 2 cols: do not rob(0) and rob(1)
        dp = [[0 for a in range(2)] for b in range(len(nums))]

        # first do not rob case
        dp[0][0] = 0

        # rob first house
        dp[0][1] = nums[0]

        for i in range(1, len(nums)):
            # do not rob or 0 case
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])

            # rob or 1 case
            dp[i][1] = dp[i-1][0] + nums[i]

        return max(dp[len(nums)-1][0], dp[len(nums)-1][1])