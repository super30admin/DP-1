# Time complexity: O(n*m) = O(n)
# Space complexity: O(n*m)
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        m = 2 # only 2 choices
        res = [ [ 0 for i in range(m) ] for j in range(n) ]
        
        # check if nums is empty or not
        if nums is None or n == 0:
            # if empty then return 0
            return 0
        
        # Initial C and DC
        res[0][0] = nums[0] # C
        res[0][1] = 0 # DC
        
        # start from 1
        for i in range(1,n):
            for j in range(m):
                # for C
                if j == 0:
                    # nums[i] + previous DC value(which means prev nums value was not chosen)
                    res[i][0] = nums[i] + res[i-1][1]
                # for DC
                else:
                    # max of prev C and DC values
                    res[i][1] = max(res[i-1][0], res[i-1][1])
        # return the max of last C and DC values
        return max(res[n-1][0], res[n-1][1])