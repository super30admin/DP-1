#TC: O(m*n)
#SC: O(m*n)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)<=0:
            return 0
        n = len(nums)
        m = 2
        matrix = [[0 for i in range(m)] for j in range(n)] 
        matrix[0][0] = nums[0]
        for i in range(1,n):
            for j in range(m):
                if j == 0:
                    matrix[i][j] = matrix[i-1][1] + nums[i] 
                else:
                    matrix[i][j] = max(matrix[i-1][1],matrix[i-1][0])
                    
        return max(matrix[n-1][0],matrix[n-1][1])
                
                    
                