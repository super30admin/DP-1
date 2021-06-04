from typing import List

# recursive Solution
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         if nums == None or len(nums) == 0:
#             return 0
#         return self.helper(nums, 0, 0)
    
#     def helper(self, nums: List[int], index: int, robbings: int) -> int:
        
#         if index >= len(nums):
#             return robbings
#         # choose
#         case1 = self.helper(nums, index + 2, robbings + nums[index])
        
#         # don't choose
#         case2 = self.helper(nums, index + 1, robbings)
        
#         return max(case1, case2)


# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         if nums == None or len(nums) == 0:
#             return 0
#         dp = [[0 for j in range(2)] for i in range(len(nums))]
#         dp[0][1] = nums[0]
        
#         for i in range(1, len(nums)):
#             dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            
#             dp[i][1] = dp[i-1][0] + nums[i]
            
#         return max(dp[len(dp)-1][0], dp[len(dp)-1][1])

# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        skip = 0
        take = nums[0]
        
        for i in range(1, len(nums)):
            temp = skip
            skip = max(skip, take)
            
            take = temp + nums[i]
            
        return max(skip, take)

obj = Solution()
print(obj.rob([1,2,3,1]))
print(obj.rob([2,7,9,3,1]))

# Time Complexity: O(n)
# Space Complexity: O(1)


