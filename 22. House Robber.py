# Time Complexity: O(n)
# Space Complexity: O(1)

# -----------------------Optimized Approach-------------------------
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums is None:
            return 0
        if len(nums) == 1: return nums[0]

        nums[1] = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            nums[i] = max(nums[i-1], nums[i-2] + nums[i])

        return nums[len(nums)-1]


# -----------------------Exhaustive Approach-----------------------
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         if len(nums) == 0 or nums is None:
#             return 0
#         return self.helper(nums, 0, 0)
    
#     def helper(self, nums, amount, index):
#         if index >= len(nums):
#             return amount
        
#         case0 = self.helper(nums, amount, index + 1)
#         case1 = self.helper(nums, amount + nums[index], index + 2)
        
#         return max(case0, case1)