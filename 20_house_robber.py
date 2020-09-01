# S30 Big N Problem #20 {Easy}
# Leetcode #198

# You are a robber planning to rob houses along a street. 
# Each house has a given amount of money, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
# Determine the maximum amount of money you can rob tonight without alerting the police.

# Time Complexity : O(nlogn) n= length of array
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach:
# Create a matrix with rob/no rob as columns and no of houses as rows. 
# At every house, if we choose to rob, then add the house's value and choose the no rob value of previous house.
# If we choose not to rob, we can rob or no rob the prev. house. Select the max. values amongst them. 


class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums)==0:
            return 0
        if len(nums)==1:
            return nums[0]
        
        dp=[[ 0 for _ in range(2)] for _ in range(len(nums))]
        
        dp[0][0]=nums[0]
        dp[0][1]=0
        for i in range(1,len(nums),1):
            
            dp[i][0]=dp[i-1][1]+nums[i]
            dp[i][1]=max(dp[i-1][0],dp[i-1][1])
        
        
        return max(dp[len(nums)-1][0],dp[len(nums)-1][1])
            
            
            
        