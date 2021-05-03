class Solution:
    def rob(self, nums: List[int]) -> int:
        
        dp = [[0 for i in range(2)] for i in range(len(nums))]
        
        for i in range(0,len(nums)):
            
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            dp[i][1] = dp[i-1][0] + nums[i]
        
        
        return max(dp[len(nums)-1][0], dp[len(nums)-1][1])
    

#  time complexity is O(n)
#  DP Array is made and for each element we are checking if to choose or not choose.
            
            
        
        
