class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dp = {}
        def backtrack(start):
            if start in dp:
                return dp[start]
            elif start >=len(nums):
                return 0
            else:
                dp[start] = max(backtrack(start+1),backtrack(start+2) + nums[start])
            return dp[start]
        return backtrack(0)