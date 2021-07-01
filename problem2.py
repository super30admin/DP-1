#brute Force
#time comp-O(n**m) 
#space comp- O(1) no space needed
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        
            return self.helper(len(nums)-1,nums)
    def helper(self,index,nums):
        
        #base case
        if index<0:
            return 0
        # to rob current house
        #if robbing current house then cant choose previous house to rob but only can          choose 1 before prev plus we have to add current amount 
        case1=self.helper((index-2),nums)+nums[index]
        
        #to not rob current house
        #if not choosing one then can choose prev house to rob
        case2=self.helper((index-1),nums)
        #we have to find out max amount to rob
        return max(case1,case2)
        
   
