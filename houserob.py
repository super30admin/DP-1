class Solution:
    def rob(self, nums: List[int]) -> int:
        #DP
        # TC O(n)
        # SC O(1)
        if nums is None or len(nums) == 0:
            return 0
        
        dp = [[0]*2 for i in range(len(nums))]
        dp[0][1] = nums[0]
        for i in range(1,len(nums)):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            
            # Current house value + value if previous house not chosen
            dp[i][1] =  nums[i] + dp[i-1][0]
        return max(dp[len(nums)-1][0],dp[len(nums)-1][1])
        
        # Exhaustive search : Time limit exceeded
        # TC O(2^3)
        # SC O(n)
#         if nums is None or len(nums) == 0:
#             return 0
#         def exhauststeal(nums, ind , money):
#             #base
#             if ind >= len(nums):
#                 return money
            
# #            logic
# #            do not choose to rob
#             case1 = exhauststeal(nums, ind + 1 , money)
    
#             #  choose to rob
#             case2 = exhauststeal(nums, ind + 2 , money + nums[ind])
#             return max(case1, case2)
            
#         return exhauststeal(nums, 0 , 0)
