class Solution:
    def rob(self, nums: List[int]):
        dp = [[0 for j in range(2)] for i in range(len(nums))]
        
        dp[0][0] = 0
        dp[0][1] = nums[0]
        
        for i in range(1,len(dp)):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            dp[i][1] = dp[i-1][0] + nums[i]
               
        return max(dp[len(dp) - 1][0],dp[len(dp) - 1][1] )
            
            
        