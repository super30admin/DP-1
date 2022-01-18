# // Time Complexity : 2^N
# // Space Complexity : 2^N
# // Did this code successfully run on Leetcode : Yes

# Recursive Solution
class Solution:
    def rob(self, nums: List[int]) -> int:
        # index = 0
        # amount =0
        if(len(nums)==0): return 0
        
        return self.helper(nums,0,0)
        
    def helper(self,nums:List[int], index:int,amount:int) -> int:
        if (index>=len(nums)): return amount
        case1=self.helper(nums,index+2,amount+nums[index]) #when house is robbed then 2 index forward
        case2=self.helper(nums,index+1,amount ) #when the house is not robbed then 1 index forward
        
        return max(case1,case2)
    

        
        
    
    
        