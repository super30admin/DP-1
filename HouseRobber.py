# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode :Yes


class Solution:
    def rob(self, nums: List[int]) -> int:
     
        if(nums==None): return 0
        n = len(nums)
        dp = [[0 for j in range(2)] for j in range(len(nums))]
        dp[0][1]=nums[0]
        for i in range(1,n):
            dp[i][0] =max(dp[i-1][0],dp[i-1][1])
            dp[i][1] = dp[i-1][0] + nums[i]
        return max(dp[n-1][0],dp[n-1][1])
        
    

        
        
    
    
        