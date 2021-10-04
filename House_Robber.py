#Time Complexity = O(m*n)
#Space Complexity = O(m*n)
#Successfully compiled and run on Leetcode

class Solution:
    def rob(self, nums: List[int]) -> int:
        if (nums == None and len(nums) == 0): #edge cases
            return 0

        n = len(nums)
        m = 2

        dp = [[0 for i in range(m)] for j in range(n)] #initializing 2d matrix

        dp[0][0] = nums[0] #initializing 1st row and 1st col
        dp[0][1] = 0

        for i in range(1, n):
            for j in range(0, m):
                if j == 0: #Choose condition
                    dp[i][j] = nums[i] + dp[i - 1][1]
                else: # dont chose condition
                    dp[i][j] = max(dp[i - 1][0], dp[i - 1][1])

        return max(dp[n - 1][0], dp[n - 1][1]) #return first and last col of last row