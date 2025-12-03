class Solution:
    def rob(self, nums: List[int]) -> int:
        # memo={}
        # def helper(index,total):
        #     if (index,total) in memo:
        #         return memo[(index,total)]
        #     if index>=len(nums):
        #         return total
        #     rob= helper(index+2,total+nums[index])
        #     skip= helper(index+1, total)
        #     memo[(index,total)]= max(rob,skip)
        #     return memo[(index,total)]
        # return helper(0,0)

        n=len(nums)
        # Taking an extra 0 for the ease of calculation
        dp = [0]*(n+1)
        dp[1]=nums[0]
        for i in range(2,n+1):
            # Either chose the current house and add it to the total of previous houses u robbed until now
            # or dont rob so the total would be max until the prev house
            dp[i]=max(dp[i-1],dp[i-2]+nums[i-1])
        return dp[n]
        