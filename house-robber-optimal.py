#I am getting index out of range error while running the dp solution on Github. 
#Also,I waould like to know best way to initialize 2d array in python. 

class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [[x for x in range(len(nums))] for y in range(0,2)]
        dp[0][0] = 0
        dp[0][1] = nums[0]
        if len(nums) == 0 or nums == None:
            return 0        
        for i in range(1,len(nums)):
            for j in range(0,2):
                if j == 0:
                    dp[i][j] = max(dp[i-1][0],dp[i-1][1])
                else:
                    dp[i][j] = dp[i-1][0] + nums[i]
        return dp[len(nums)-1][0]