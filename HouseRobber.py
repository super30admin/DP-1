# Time Complexity : O(n) n is the length of nums array
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I used technique of dynamic programming, as the adjacent houses have security alarm, 
#I am comparing the maximum amount of robbing  amount of present house and previous house leaving one house in the middle, and the previous house.
This gives me the maximum amount to be robbed by the end of the street.



class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        dp = [0]*(len(nums)+1)
        
        dp[0] = 0
        dp[1] = nums[0]
        
        for i in range(2,len(dp)):
            dp[i] = max(dp[i-1],dp[i-2]+nums[i-1])
        return dp[-1]