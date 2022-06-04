""""// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def rob(self, nums):
        if not nums or len(nums)==0:
            return -1
        if len(nums)<2:
            return nums[0]
        prev= nums[0]
        curr= max(nums[0],nums[1])
        for i in range(2, len(nums), 1):
            temp=max(curr,prev+nums[i])
            prev=curr
            curr=temp
        return curr
""""// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

# class Solution:
#     def rob(self, nums):
#         if not nums or len(nums) == 0:
#                 return -1
#         if len(nums)<2:
#             return nums[0]
#         dp=[None]*100
#         dp[0]=nums[0]
#         dp[1]=max(nums[0],nums[1])
#         for i in range(2, len(nums), 1):
#             dp[i]=max(dp[i-1], dp[i-2]+nums[i])
#         return dp[len(nums)-1]



#Exhaustive Approaches-
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         if not nums or len(nums)==0:
#             return -1
#         return self.helper(nums,0,0)

#     def helper(self, nums, index, amount):
#         #base
#         if index>=len(nums):
#             return amount
#         #choosing
#         case1=self.helper(nums, index+2, amount+nums[index])
#         #notchoosing
#         case2=self.helper(nums, index+1, amount)
#         return max(case1, case2)


# class Solution:
#     def rob(self, nums):
#         n = len(nums)
#         if not nums or len(nums) == 0:
#             return -1
#         if n <= 2:
#             return max(nums)
#         case1 = self.helper(nums, 0, 0)
#         case2 = self.helper(nums, 1, 0)
#         return max(case1, case2)
#
#     def helper(self, nums, index, maxVal):
#         n = len(nums)
#         # base
#         if index >= n-1:
#             return maxVal
#         # logic
#
#         case1 = self.helper(nums, index + 2, maxVal + nums[index])
#         case2 = self.helper(nums, index + 3, maxVal + nums[index])
#         return max(case1, case2)
# Obj=Solution()
# print(Obj.rob([1,7,1,1,7]))

#         n=len(nums)
#         max=0
#         for i in range(n-1,-1,-1):
#             if nums[i-2]<nums[i-3]:
#                 max= nums[i]+nums[i-3]
#                 i=i-3
#             max= nums[i]+nums[i-2]
#             i=i-2
#         return max


