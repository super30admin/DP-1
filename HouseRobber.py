#Dynamic Programming is used in the below approach
#Time complexity=O(n)
#Space complexity=O(n)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums==None or len(nums)==0:
            return 0

        n=len(nums)
        dp=[[0 for i in range(2)] for j in range(n)]
        dp[0][1]=nums[0]
        for i in range(1,n):
            dp[i][0]=max(dp[i-1][0],dp[i-1][1])
            dp[i][1]=dp[i-1][0]+nums[i]
        return max(dp[n-1][0],dp[n-1][1])
