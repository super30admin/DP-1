class Solution:
    def rob(self, nums: List[int]) -> int:
        n=len(nums)
        
        def dp(i):
            if i==0:
                return nums[0]
            if i==1:
                return max(nums[0], nums[1])
            if i not in memo: 
                memo[i]=max(dp(i-1), dp(i-2)+nums[i])
            
            return memo[i]
        
        memo={}
        return dp(n-1)
        