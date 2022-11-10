#Time complexity: O(n) where n is the number of houses
#Space complexity: O(n) to store the DP array

#Accepted on Leetcode

#Approach:
#Solution can be formulated only using an extra 1D array
#We can only rob alternate houses, so solution for 1st house 'only' will be the value itself and solution for 1st and 2nd house 'only' will be 
#max(0th value in nums arr, 1st val in nums arr)
#From then on soln to each subproblem = max(i-1 th solution, current house val + i - 2th solution)

class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0
        
        dp = [nums[i] for i in range(n)]
        #index 0 and 1's correct value is nums[0] and max(nums[1],nums[0]) resp
        if n > 1:
            dp[1] = max(dp[0], dp[1])

        for i in range(2, n):
            dp[i] = max(dp[i-1], nums[i] + dp[i-2])


        return dp[n-1]

#TC
#A = [2,1,5,9,6], DP = [2, 2, 5, 9, 6]
# i = 2, DP[2] = max(2, 5 + 2) = 7, DP = [2, 2, 7, 9, 6]
# i = 3, DP[3] = max(7, 9+2) = 11, DP = [2, 2, 7, 11, 6]
# i = 4, DP[4] = max(9, 6+7) = 13, DP = [2, 2, 7, 11, 13]
# Return 13
