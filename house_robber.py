class Solution:
    def rob(self, nums: List[int]) -> int:
        
        ## Approach 2: Memory efficient
        ## TC = O(n)
        ## SC = O(1)
        
        skip = 0
        rob = nums[0]
        
        for i in range(1, len(nums)):
            tmp1 = skip
            skip = max(tmp1, rob)
            rob = tmp1 + nums[i]
            
        return max(skip, rob)

        ## Approach 1
        ## TC = O(n)
        ## SC = O(n)
        
        rob = [[0]*2 for i in range(len(nums))]
        rob[0][1] = nums[0]
    
        for i in range(1, len(nums)):
            
            rob[i][0] = max(rob[i-1][0], rob[i-1][1])
            rob[i][1] = rob[i-1][0] + nums[i]
       
        return max(rob[len(nums)-1][0], rob[len(nums)-1][1])
        
