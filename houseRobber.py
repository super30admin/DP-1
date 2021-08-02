#Leetcode Problem 198
class Solution:
    def rob(self, nums):
        zeroInd=0 # not choose to rob
        oneInd=0 # choose to rob
        for i in range(len(nums)):
            temp=zeroInd
            zeroInd=max(zeroInd,oneInd)
            oneInd=temp+nums[i]
        return max(zeroInd,oneInd)

#TC: O(n)
#SC: O(1)

#####Extra approach####
# def rob(self, nums):
#         dp=[[0]*2]*len(nums)
#         for i in range(len(dp)):
#             dp[i][0]=max(dp[i-1][0],dp[i-1][1])
#             dp[i][1]=dp[i-1][0]+nums[i]
#         return max(dp[-1][0],dp[-1][1])