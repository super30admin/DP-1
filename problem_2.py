""" Time Complexity : O(n)
 Space Complexity : O(mn)
 Did this code successfully run on Leetcode :Yes
 Any problem you faced while coding this : No 
"""

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        
        dp = [[0]*2 for i in range(len(nums) )]
        print(dp)
        dp[0][1] = nums[0]
        
        for i in range(1,len(nums)):
            dp[i][0] = max(dp[i-1][0],dp[i-1][1])
            dp[i][1] = nums[i] + dp[i-1][0]
            
        return max(dp[len(dp)-1][0], dp[len(dp)-1][1])
        
        
        
        
        