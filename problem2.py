class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums:
            matrix = [[0]*2 for _ in range(len(nums))]
            matrix [0][1] =nums[0]
            
            for i in range(1, len(nums)):
                matrix[i][0] = max(matrix[i-1][0], matrix[i-1][1]) # not choosing the house
                matrix[i][1] = matrix[i-1][0] + nums[i] # choosing the house
                
            return max(matrix[len(nums)-1][0],matrix[len(nums)-1][1])
        
        else:
            return 0
        
#time complexity would be O(n) where n is length of the nums array
#space complexity will also be O(n) as we are storing each element in the nums array in an auxiliary data structure