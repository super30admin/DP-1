#exhaustive Approach:
# from typing import List
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         if len(nums)==0:
#             return 0
#         return self.helper(nums,0,0)
#
#
#     def helper(self,nums,robbings,index):
#         #base case
#         if index>=len(nums):
#             return robbings
#         #do not choose the house
#         case1=self.helper(nums,robbings,index+1)
#         #choose the house
#         case2=self.helper(nums,robbings+nums[index],index+2)
#         return max(case1,case2)
#

#DP Approach

class Solution:
    def rob(self, nums: List[int]) -> int:
        dp=[[0]*2 for num in range(len(nums))]
        #print(dp)
        dp[0][1]=nums[0] #initialize 1st row
        #print(dp)
        for i in range(1,len(dp)):
            dp[i][0]=max(dp[i-1][0], dp[i-1][1])
            dp[i][1]=dp[i-1][0]+nums[i]

        return max(dp[len(dp)-1][0],dp[len(dp)-1][1])

            