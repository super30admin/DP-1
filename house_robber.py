#time complexity: O(n)
#space complexity: O(n)

class Solution:
    def rob(self, nums):
        self.nums=nums
        
        if(nums==None or len(nums)==0):
            return 0
        
        dp=[[0]*2 for _ in range(len(nums))]
        
        print(dp)
        
        dp[0][0]=0
        dp[0][1]=nums[0]
        
        for i in range(1, len(nums)):
            dp[i][0]=max(dp[i-1][0], dp[i-1][1])
            dp[i][1]=dp[i-1][0]+nums[i]
            
        return max(dp[len(nums)-1][0], dp[len(nums)-1][1])
            