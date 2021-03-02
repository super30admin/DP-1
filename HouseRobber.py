# Top Down Approach - Dynamic Programming
# Time Complexity - O(N)
# Space Complexity - O(N)


class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return 0
        
        if len(nums)==1:
            return nums[0]
                
        self.dp = [None]*len(nums)
        
        return self.helper(nums,len(nums)-1)
    
    def helper(self,nums,i):
        if i<0:
            return 0
        if self.dp[i] != None:
            return self.dp[i]
        
        self.dp[i]= max(self.helper(nums,i-2)+nums[i],self.helper(nums,i-1))
        
        return self.dp[i]


'''

# Time Complexity - O(N)
# Space Complexity - O(1)

Algorithm - Bottom up approach Dynamic Programming

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return 0
        
        if len(nums)==1:
            return nums[0]
        
        first=nums[0]
        second=max(nums[0],nums[1])
        maximum=second
        for i in range(2,len(nums)): # For every position, we are storing the maximum amount till that position
            maximum=max(nums[i]+first,second) #
            first=second
            second=maximum
            
            
        return maximum
        
'''
        