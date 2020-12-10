# DP solution
# Time complexity : O(n) ; n = number of houses in array
# Space complexity : O(1) 
# Approach : At every iteration we compare skip and take, whichever is max, we update our skip and take variables, in the end, we return max of skip and take, we denotes max amount.
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0
        skip = 0
        take = nums[0]
        for i in range(1, len(nums)):
            temp = max(skip, take)
            take = skip + nums[i]
            skip = temp
            
        return max(skip, take)
        
        

# Recursive solution : Time Limit Exceeded
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         if not nums or len(nums) == 0:
#             return 0
        
#         return self.helper(nums, 0, 0)
    
#     def helper(self, nums, index, maxHouses):
#         # Base
#         if index >= len(nums):
#             return maxHouses
        
#         # Logic
#         case1 = self.helper(nums, index + 1, maxHouses)
#         case2 = self.helper(nums, index + 2, maxHouses + nums[index])
        
#         return max(case1, case2)