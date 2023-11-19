class Solution:
    def rob(self, nums: List[int]) -> int:
        dp=[i for i in nums]
        if len(nums)==1:
            return nums[0]
        if len(nums)>1:
            dp[1]=max(nums[0],nums[1])
            for i in range(2,len(nums)):
                dp[i]=max(dp[i-2]+nums[i],dp[i-1])
            print(dp)
            return dp[len(nums)-1]

            

        