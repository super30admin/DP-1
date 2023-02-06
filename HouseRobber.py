# Author: Naveen US
# Title: House robber

# Time Complexity : O(N), M being the length of array
# Space Complexity : O(N), M being the length of array
# Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : I found the problem difficult ad had to get help and refer to solutions to finsh the assignment. 

class Solution:
    def helper(self, nums, index, dp):
        if index>=len(nums)+2:
            return 0
        else:
            if dp[index]==None:
                result1 = self.helper(nums, index+1, dp)
                result2 = nums[index]+self.helper(nums, index+2, dp)
                dp[index]=max(result1, result2)  
            return dp[index]

    def rob(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        else:
            dp=[None for i in range(len(nums)+2)] 
            dp[len(dp)-1]=0
            dp[len(dp)-2]=0 
            result = self.helper(nums, 0, dp)

            return result
