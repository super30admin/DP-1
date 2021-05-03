class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums)==0:
            return 0
        
        return self.helper(nums, 0, 0)
    
    def helper(self, nums:List[int],index: int, amount: int):
        
#         base case
        if index>=len(nums):
            return amount
        
        
#         choose:
        caseChoose = self.helper(nums,index+2, amount+nums[index])
#     Dont choose:
        caseDontChoose = self.helper(nums, index+1, amount)

        return max(caseChoose, caseDontChoose)
    
#     this is recursive solution, time complexity is exponential.
