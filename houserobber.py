#time complexity:O(n), have to go through array
#space complexity:o(1) only 3 variables
#passed all cases on LeetCode: yes
#difficulty faced:
# comments:
#https://leetcode.com/problems/house-robber/

class Solution:
    def rob(self, nums: 'List[int]') -> int:
        
        if(nums is None or len(nums)==0): return 0
        
        #dp = [0*2]*n
        skip,take,temp = 0,nums[0],0
        
        #we have temp variable to remember skip for the next take
        for i in range(1,len(nums)):
            temp = skip
            skip = max(skip,take)
            take = temp + nums[i]
            
        return max(skip,take)
            
        
        
"""
    skip    take
2   0       2
7   2       7+0
9   7       11
8   11      15
1   
"""