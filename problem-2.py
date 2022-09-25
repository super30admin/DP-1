# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :

from typing import List
#dp solution
def rob(nums: List[int]) -> int:
    n = len(nums)
    
    dp = [[0] * 2 for _ in range(n)]
    dp[0][1] = nums[0]
    
    for i in range(1, n):
        dp[i][0] = max(dp[i-1][0], dp[i-1][1])
        dp[i][1] = nums[i] + dp[i-1][0]
    
    return max(dp[n-1][0], dp[n-1][1])
    
    
    
    

    
    
    
    
##Recursive solution
#     def rob(self, nums: List[int]) -> int:
#         return self.helper(nums, 0, 0)
    
#     def helper(self, nums: List[int], index: int, amountRobbed: int) -> int:
#         #base case
#         if index >= len(nums):
#             return amountRobbed
        
#         #logic
#         #case 0  - do not rob current house
#         case0 = self.helper(nums, index+1, amountRobbed)
#         #case 1  - rob current house
#         case1 = self.helper(nums, index+2, amountRobbed + nums[index])

#         return max(case0, case1)

nums = [1,2,3,1]

print(rob(nums))