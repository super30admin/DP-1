class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #DP- Bottom Up
        dp = [0 for i in range(len(nums)+1)]
        dp[0] = 0
        dp[1] = nums[0]
        for i in range(2, len(nums)+1):
            dp[i] = max(dp[i-1], (dp[i-2]+nums[i-1]))
        return dp[len(nums)]


        #Exhaustive Approach
        # def helper(nums, index, loot, memo):
        #     #memo
        #     if memo.has_key((index, loot)):
        #         return memo[(index,loot)]
        #     #Base
        #     if index >= len(nums): return loot
        #     #logic
        #     case1 = helper(nums, index+1, loot, memo)
        #     case2 = helper(nums, index+2, loot+nums[index], memo)
        #     result = max(case1, case2)
        #     memo[(index, loot)] = result
        #     return result
        # return helper(nums, 0, 0, {})