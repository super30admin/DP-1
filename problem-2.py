# Leetcode Execution: YES
# Time Complexity: O(n)
# Space Complexity:O(1)

class Solution:
    def rob(self, nums: List[int]) -> int:
        # using choose not choose case mixed with dp
        x=0
        y=nums[0]
        # loop thoroigh the array given 
        for i in range(1,len(nums)):
             # first we keep aside value of x for further use case
               # not choose case 'x' should be max of x and y or prev choose not choose case
               # choose case should be coupled with curent value + prev not choose case since we cannot include previous choose case 
               # for obvious reasons as we are not allowed to rob two adjacent houses
            prev=x
            x=max(x,y)
            y=prev+nums[i]
        
        
        # finally return max of choose  not choose case    
        return max(x,y)
            
       
    