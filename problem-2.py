"""
Approach

1. To find the maximum amount that can be collected we can start with finding the maximum no of coins that can be earner by either choosing or not choosing the 1st house. 
2. the value computed above will help us find the maximum amount that can be earned by choosing or not choosing the 2nd house given the 1st house is robbed or not
3. we create a Dp matrix with row header as amounts and column header as 0,1 representing to choose or not to choose the current house

"""


# Time Complexity : O(n) where n is the number of houses
# Space Complexity : O(n) where n is the number of houses
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums)==0:
            return 0
        
        dp  = [ [None for j in range(2)]for i in range(len(nums))]
        dp [0][0] = 0
        dp[0][1] =nums[0]
        
        for i in range(1,len(nums),1):
            dp[i][0]=max(dp[i-1][0],dp[i-1][1])
            dp[i][1]= nums[i]+ dp [i-1][0]
        return max(dp[len(nums)-1][0],dp[len(nums)-1][1])