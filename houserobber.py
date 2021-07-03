class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #if not nums or len(nums)==0:
         #   return 0
        a=nums[0]
        b=0
        #dp = [[0 for i in range(2)] for j in range(len(nums))]
        #dp[0][1]=nums[0]
        for i in range(1,len(nums)):
            #dp[i][0]=max(dp[i-1][0],dp[i-1][1])
            #dp[i][1]=dp[i-1][0]+nums[i]
            c=b
            b=max(a,b)
            a=c+nums[i]
            
        return max(a,b)