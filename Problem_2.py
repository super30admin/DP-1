"""
Problem : 2

Recursive
Time Complexity : O(2^m))
Space Complexity : O(2^m)

DP
Time Complexity : O(m)
Space Complexity : O(m)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

In recursive solution - changing the array selection based on whether to choose the house or not, 
keeping track of the robbings and returning the maximum robbings at the end
In dp approach - creating a dp array, because of just one decision factor and implementing the recursive tree in the form of array 

"""

# House Robber Problem

# Approach - 1

class Solution(object):
    def rob(self, nums):
        if nums==None:
            return 0
        return self.helper(nums,0,0)
    
    def helper(self,nums,idx,robbings):

        # base
        if idx>=len(nums):
            return robbings

        # choose
        case0=self.helper(nums,idx+2,robbings+nums[idx])
        # not choose
        case1=self.helper(nums,idx+1,robbings)

        return max(case0,case1)
    
# Approach - 2

class Solution(object):
    def rob(self, nums):
        dp=[0 for _ in range(len(nums))]
        dp[0]=nums[0]

        for i in range(1,len(nums)):
            dp[i]=max(nums[i]+dp[i-2],dp[i-1])

        return dp[len(nums)-1]
    
# Constant Space Complexity
 
class Solution(object):
    def rob(self, nums):
        n=len(nums)
        if n==0:
            return 0
        if len(nums)==1:
            return nums[0]
        if len(nums)==2:
            return max(nums[0],nums[1])

        prev=nums[0]
        curr=max(nums[0],nums[1])
        

        for i in range(2,len(nums)):
            temp=curr
            curr=max(curr,prev+nums[i])
            prev=temp


        return curr