# Recursive solution

# Doesn't run on Leetcode
    # Runtime - O()
    # Memory - O(n) - considering the recursive stack
    
    
class Solution:
    def rob(self, nums: List[int]) -> int:
        return self.recursion(nums,0,0)
    
    def recursion(self,nums,index,amount):
        if index >= len(nums):
            return amount
        
        not_chosen = self.recursion(nums,index+1,amount)
        chosen = self.recursion(nums,index+2,amount+nums[index])
        
        return max(chosen, not_chosen)
        
   
   
# DP solution

# Runs on Leetcode
    # Runtime - O()
    # Memory - O()
