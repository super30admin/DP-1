# Time Complexity :  O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes      
# Any problem you faced while coding this : No  

# Your code here along with comments explaining your approach: We use a memo array to store the previous results. We use recursion for this problem. There is 0 case and a 1 case. Based on the case the indices keep moving. We then store the max of the two cases in the memoization array.

class Solution:
    def rob(self, nums: List[int]) -> int:
        self.memo = [-1] * len(nums)
        return self.helper(nums, 0)
    
    def helper(self, nums, i):
        if i >= len(nums):
            return 0
        
        if self.memo[i] != -1:
            return self.memo[i]

        case1Sum = nums[i] + self.helper(nums, i + 2)
        
        case2Sum = self.helper(nums, i + 1)
        re = max(case1Sum, case2Sum)
        self.memo[i] = re

        return re


#Recursion Solution --> Time Limit Exceeded
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         return self.helper(nums, 0, False, 0)
    
#     def helper(self, nums, i, lastHouseChosen, currentSum):
#         if i == len(nums):
#             return currentSum
        
#         case1Sum = 0

#         if(not lastHouseChosen):
#             case1Sum = self.helper(nums, i + 1, True, currentSum + nums[i])
        
#         case2Sum = self.helper(nums, i + 1, False, currentSum)

#         return max(case1Sum, case2Sum)