# Time Complexity: O(n)
# Space complexity: O(1) in approach 1 and O(n) in approach 2

# The codes successfully ran on Leetcode

##### Approach 1 ######
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        
        if n == 0 or nums == None:
            return 0
        
        skip = 0
        take = nums[0]
        
        for i in range(1, n):
            temp = skip
            skip = max(skip, take)
            take = temp + nums[i]
            
        return max(skip, take)



####### Approach 2 ########
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         if len(nums) == 0 or nums == None:
#             return 0
        
#         dp = [[0 for x in range(2)] for y in range(len(nums))]
#         dp[0][1] = nums[0]
        
#         for i in range(1, len(nums)):
#             dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
#             dp[i][1] = dp[i - 1][0] + nums[i]
            
#         return max(dp[len(nums) - 1][0], dp[len(nums) - 1][1])
        