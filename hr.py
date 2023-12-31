class Solution:
    
#recursion with memoization
    
#     def findCombination(self, ind, nums, memo):
        
#         #base
#         if ind >= len(nums):
#             return 0
        
#         if ind in memo:
#             return memo[ind]
        
#         case1 = nums[ind] + self.findCombination(ind+2, nums, memo) 
        
#         case2 = self.findCombination(ind+1, nums, memo)
        
#         memo[ind] = max(case1, case2)
        
        
#         return memo[ind]
    
#     def rob(self, nums: List[int]) -> int:
        
#         if nums is None or len(nums) == 0:
#             return 0;
        
#         if len(nums) < 2:
#             return nums[0]
        
#         memo = {}
        
#         return self.findCombination(0, nums, memo)


# dynamic programming - tabulation

#     def rob(self, nums: List[int]) -> int:
#         if len(nums) == 0:
#             return 0

#         n = len(nums)
#         dp_amount = [-1 for _ in range(n + 1)]

#         # Base cases
#         dp_amount[0] = 0
#         dp_amount[1] = nums[0]

#         for i in range(2, n + 1):
#             dp_amount[i] = max(dp_amount[i - 1], dp_amount[i - 2] + nums[i - 1])
            
#         print(dp_amount)

#         return dp_amount[n]

# tabulation + space optimised


    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0

        prev1 = 0
        prev2 = 0

        for num in nums:
            temp = prev1
            prev1 = max(prev1, prev2 + num)
            prev2 = temp

        return prev1



    
        
        
        
