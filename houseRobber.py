class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return 0
        n = len(nums)
        dp  = [0 for i in range(n)]
        
        dp[0] = nums[0]
        if len(nums) == 1:
            return nums[0]
        
        if len(nums) == 2:
            return max(nums[1],nums[0])
        dp[1] =  max(nums[1],nums[0])
        for i in range(2,n):
            dp[i] = max(dp[i-1],dp[i-2]+nums[i])
   
        return dp[n-1]
        
        

        
'''
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return 0
        n = len(nums)
        dp  = [[0 for i in range(2)] for i in range(n)]
        
        dp[0][0] = 0
        dp[0][1]  = nums[0]
        for i in range(1,n):
            dp[i][0] = max(dp[i-1][1],dp[i-1][0])
            dp[i][1] = nums[i]  + dp[i-1][0]
        print(dp)   
        return max(dp[n-1][0],dp[n-1][1])

'''



'''
 class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return 0
        
        return self.helper(nums, 0, 0)
    
    def helper(self,nums, index, amount):
        #base
        if index >= len(nums):
            return amount
        
        #logic
        case1 = self.helper(nums, index+2, amount+nums[index])
        case2 = self.helper(nums, index+1, amount)
        
        return max(case1, case2)
 '''       