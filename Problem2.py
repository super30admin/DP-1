class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        if len(nums) <= 2:
            return max(nums)
        
        dp = [0]*len(nums)
        
        dp[0] = nums[0]
        dp[1] = max(nums[0],nums[1])
        
        for x in range(2,len(nums)):
            dp[x] = max(dp[x-1], nums[x]+dp[x-2])
            
        return dp[-1]
    
# time complexity 0(N), Iterating through all the elements and adding to the dp array. Then check if the max length is greater in previous element or curruent element plus previous dp.
