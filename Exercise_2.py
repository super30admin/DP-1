#Time Complexity : O(N), M being the length of array
#Space Complexity : O(N), M being the length of array
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : I had extreme trouble with indices and 
#changing from recursion to dp. I ahd to also look at the video for help since I was
#initially trying to use a dp array of 3*n dimensions. 

#Your code here along with comments explaining your approach in three sentences only
'''Used dynamic programming to lower complexity of recursion method. 
'''
class Solution:
    def helper(self, nums, index, dp):
        if index>=len(nums)+2:
            return 0
        else:
            #if dp value is None, fill with max of previous value and 
            # current + prev, prev value. 
            if dp[index]==None:
                result1 = self.helper(nums, index+1, dp)
                result2 = nums[index]+self.helper(nums, index+2, dp)
                dp[index]=max(result1, result2)  
            return dp[index]

    def rob(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        else:
            #initialize dp array. 
            dp=[None for i in range(len(nums)+2)] 
            dp[len(dp)-1]=0
            dp[len(dp)-2]=0
            #call helper function. 
            result = self.helper(nums, 0, dp)

            return result