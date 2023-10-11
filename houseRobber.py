class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        dp = [0] * (len(nums) + 1)
        for i in range(len(nums)):
            dp[i + 1] = max(dp[i - 1] + nums[i], dp[i])
        return dp[-1]

        # Brute Force
        """def helper(nums, idx, amount):
            if idx >= len(nums): return amount
            # use the house
            case1 = helper(nums, idx+2, amount+nums[idx])

            # skip the house
            case2 = helper(nums, idx+1, amount)

            return max(case1,case2)

        return helper(nums,0,0)"""