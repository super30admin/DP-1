#Time Complexity O(m*n)
#Space Complexity O(n)

class Solution:
    #Recursive Approach
    def func(self,nums,ind,amt):
        #base case
        if ind>=len(nums):
            return amt
        
        #actual logic
        
        #choose
        case1 = self.func(nums,ind+2,nums[ind]+amt)
        
        #not choose
        case2 = self.func(nums,ind+1,amt)
        
        return max(case1,case2)
        
    
    def rob(self, nums: List[int]) -> int:
        if nums==None:
            return 0
        if len(nums)==0:
            return 0
        dp = [[0 for x in range(3)] for y in range(len(nums))]
        
        for x in range(len(nums)):
            dp[x][0] = nums[x]
        
        dp[0][1] = 0
        dp[0][2] = nums[0]
        for x in range(1,len(dp)):
            dp[x][1] = max(dp[x-1][1],dp[x-1][2])
            dp[x][2] = nums[x]+ dp[x-1][1]
            
        return max(dp[-1][-1],dp[-1][-2])
                                                   
                                                   
        #Recursive Approach
        #return self.func(nums,0,0)
        
        
        
        pass
        
        
        
        
        
        
        
        
