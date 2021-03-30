# DP-1

## Problem1 (https://leetcode.com/problems/coin-change/)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        minimum = 0
        matrix = [[0] * (1+amount) for _ in range(len(coins)+1)]
        for i in range(1+amount):
            matrix[0][i] = amount+1
        matrix[0][0] = 0
        c = 1+amount
        r = 1+len(coins)
        for i in range(1,r):
            for j in range(1,c):
                if j>=coins[i-1]:
                    matrix[i][j] = min(matrix[i-1][j], matrix[i][j-coins[i-1]]+1)
                else:
                    matrix[i][j] = matrix[i-1][j]
        if matrix[r-1][c-1] == amount+1:
            return -1
        else:
            return matrix[r-1][c-1]
    
    <!-- #Time coplexity: m*n where m - number of rows - amount, n - avg length of number of coins
    #Space complexity: O(mn)
    #Approach: Build a Matrix based on the the amount and number of coins as the rows and columns respectively. When we analyse using brute force technique to choose the coin or not, we do repeated calculations by not realising that we already have the value calculated. Exploiting this technique, we will construct the matrix and return the last element of the matrix.  
    # matrix = []m -->

## Problem2 (https://leetcode.com/problems/house-robber/)

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums == []:
            return 0
        l = len(nums)
        dp = [[0 for i in range(2)] for j in range(len(nums))]
        dp[0][1] = nums[0]
        for i in range(1,len(nums)):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            dp[i][1] = dp[i-1][0]+nums[i]
        return max(dp[len(nums)-1][0], dp[len(nums)-1][1])
            
<!-- #Time Complexity: O(n) n - length of the nums
#Space Complexity: O(n) n - dp matrix - no of rows - len(nums) -->
<!-- # Approach - Dynamic programming.  -->

