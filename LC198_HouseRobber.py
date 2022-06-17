
"""

Greedy approach - we will take elements at odd and even indexes and see which one is max
Will fail when the sum is equal [ 2,1,1,2]

Exhaustive approach - 
we consider choosing or not choosing each house

[6,9,8,1,1,5]

In this case the decision making criteria would be the current array (houses left to rob) to maximize the amount by robbing from them

TC = O(n)
SC = O(n)


"""

# # RECURSIVE SOLUTION
# class Solution:
#     def rob(self, nums: list[int]) -> int:
#         if (nums == None or len(nums)==0):
#             return 0
#         return helper(nums, 0, 0)

# def helper (nums, i, amount) ->int:
#     if i>=len(nums):
#         return amount
#     # case choose
#     case1 = helper(nums, i+2, amount+nums[i])
#     # case not choose
#     case2 = helper(nums, i+1, amount)

#     return max(case1, case2)
# object = Solution()
# nums = [1,2,3,1]
# ans = object.rob(nums)
# print(ans)

# 

# DP Solution
class Solution:
    def rob(self, nums : list[int]) ->int:
        if len(nums)==1:
            return nums[0]
        
        prePrevious=nums[0]
        previous=max(nums[0],nums[1])
        
        for i in range(2, len(nums)):
            curr = max(previous,nums[i]+prePrevious)
            prePrevious = previous
            previous = curr
            
        
        return previous
    
object = Solution()
# nums = [6,9,8,1,1,5]
nums = [1,2,3,1]
ans = object.rob(nums)
print(ans)


        


        
        