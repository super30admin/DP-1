# // Time Complexity : 2^N
# // Space Complexity : 2^N
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach
class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums == None:
            return 0
        return self.helper(nums,0,0)

    def helper(self,nums, index, amount):
        #base
        if index >= len(nums):
            return amount
        
        
        # choose the house
        case1 = self.helper(nums, index + 2, amount + nums[index])
        
        # not choose the house
        case2 = self.helper(nums, index + 1, amount)
        
        return max(case1, case2)
    
        
        