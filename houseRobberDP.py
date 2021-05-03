class Solution:
    def rob(self, nums: List[int]) -> int:
        
        dp = [[0 for i in range(2)] for i in range(len(nums))]
        
        for i in range(0,len(nums)):
            
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            dp[i][1] = dp[i-1][0] + nums[i]
        
        
        return max(dp[len(nums)-1][0], dp[len(nums)-1][1])
    

#  time complexity is O(n)
#  DP Array is made and for each element we are checking if to choose or not choose.
           
# further optimization

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        
        skip=0
        take = nums[0]
        
        for i in range(1,len(nums)):
            temp = skip
            skip = max(skip, take)
            take = temp + nums[i]
        
        
        return max(skip, take)
    

#  time complexity is O(n)
#  space complexity is reduced as you dont need new array to store dp array 
            
            
        
        
