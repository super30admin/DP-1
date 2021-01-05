# TC = O(n)
# SC = O(1)
# First we deduce usinf recursive tree- there is only one varying parameter- one index - 1D DP array required. 
# recursive approach
# def rob(nums):
#     if not nums or len(nums) == 0:
#         return 0
#     return helper(nums,0)
# def helper(nums,ind):
#     # base
#     if ind >= len(nums):
#         return 0 
#     # logic
#     case0 = helper(nums, ind+1)
#     case1 = nums[ind] + helper(nums, ind+2)
#     return max(case0, case1)

# DP approach: subproblems which we trace back each time are prev element and prev of prev element
class Solution:
    def rob(self,nums):
        if not nums or len(nums) == 0: return 0
        if len(nums) == 1: return nums[0]
        dp = [0] * len(nums)
        for i in range(len(nums)):
            dp[i] = max(dp[i-1],nums[i] + dp[i-2])
        print(dp)
        return dp[len(nums)-1]