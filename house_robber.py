# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Basic Approach is to use the exhaustive method, trying to find out every possibility to tob maximum amount of money making sure the constraint is followed. Used single array to 




class Solution:
    def rob(self, nums: List[int]) -> int:
        if(len(nums)==0):
            return 0
        if(len(nums)==1):
            return nums[0]
        
        dp = [0]*len(nums)
        dp[0]=nums[0]
        dp[1]=max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            dp[i] = max(dp[i-1], nums[i]+dp[i-2])
            
        return dp[-1]
        