#Problem 2 : https://leetcode.com/problems/house-robber/
#Test Cases Passed on LeetCode
#Time Complexity-O(N)
#Space Complexity-O(N*2)=O(N) *Please confirm if it is correct or not

class Solution:
    def rob(self, nums):
        if not nums or len(nums)==0:
            return 0
        #declare a 2 array where columns tell us whether the num [i] is selected or not
        dp=[[0 for col in range(2)] for row in range(len(nums))]
        dp[0][0]=0
        dp[0][1]=nums[0]
        for i in range(1,len(nums)):
            #if we do not select nums[i]
            dp[i][0]=max(dp[i-1][0],dp[i-1][1])
            #if we select nums[i]
            dp[i][1]=nums[i]+dp[i-1][0]
        return max(dp[-1][0],dp[-1][1])
sol=Solution()
nums = [1, 2, 3, 1]
print(sol.rob(nums))
