# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode :Yes


class Solution:
    def rob(self, nums: List[int]) -> int:
     
        if(nums==None): return 0
        n = len(nums)
        # dp = [[0 for j in range(2)] for j in range(len(nums))]
        skip =0
        take = nums[0]
       
        for i in range(1,n):
            temp = skip
            skip = max(skip,take)
            take = temp +nums[i]
        return max(skip,take)
        
    

        
        
    
    
        