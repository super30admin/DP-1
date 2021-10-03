# TC-O(n*m)
# SC-O(n*m)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if (len(nums)==0):
            return 0
        m=len(nums)
        n=2
        dp= [[0 for i in range(n)] for j in range(m)]
        print(dp)
        dp[0][0]=nums[0]
        dp[0][1]=0
        for i in range(1,m):
            dp[i][0]=dp[i-1][1]+nums[i]
            dp[i][1]=max(dp[i-1][0], dp[i-1][1])
        return max(dp[m-1][0],dp[m-1][1])