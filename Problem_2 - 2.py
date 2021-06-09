"""

Time Complexity : O(n*2) where n is number of houses.
Space Complexity : O(n*2)
    
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0 
        
        matrix = [[0 for _ in range(2)]for _ in range(len(nums))]
        
        matrix[0][1] = nums[0]
        for i in range(1, len(nums)):
            matrix[i][0] = max(matrix[i-1][0], matrix[i-1][1])
            matrix[i][1] = matrix[i-1][0] + nums[i]
        
        return max(matrix[len(nums)-1][0], matrix[len(nums)-1][1])
            
        