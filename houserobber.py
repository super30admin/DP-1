class Solution:
    def rob(self, nums: List[int]) -> int:
        #edge case
        if(nums==None or len(nums)==0):
            return 0
        if(len(nums)==1):
            return nums[0]
        rows=len(nums)
        dp=[[None for i in range(0,2)] for j in range(rows)]
        for i in range(1,len(nums)):
            for j in range(2):
                dp[0][0]=0
                dp[0][1]=nums[0]
                if(j==0):
                    dp[i][j]=max(dp[i-1][0], dp[i-1][1])
                else:
                    dp[i][j]=dp[i-1][0] + nums[i]
        return max(dp[rows-1])
