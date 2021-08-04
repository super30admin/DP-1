//Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO




class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) ==0:
            return 0
        M = 2
        N = len(nums)
        dp=[ [ 0 for i in range(M) ] for j in range(N) ]
        dp[0][1] = nums[0]
        dp[0][0] = 0
        for i in range(1,len(nums)):
            dp[i][0] = max(dp[i-1][0],dp[i-1][1])
            dp[i][1] = dp[i-1][0] + nums[i]
        return max(dp[len(dp)-1][0],dp[len(dp)-1][1])
        
        
        
#         if len(nums) == 0:
#             return 0
#         return self.helper(nums,0,0)
#     def helper(self,nums,index,amount):
#         #base case
#         if index>=len(nums):
#             return amount
#         #logic
#         #1.Do not rob case
#         case1=self.helper(nums,index+1,amount)
#         #2.Rob case
#         case2= self.helper(nums,index+2,amount + nums[index])
        
#         return max(case1,case2)