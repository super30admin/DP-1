#Time complexity: O(m*n) where m and n are the number of coins and the amount respectively
#Space complexity: O(m*n)

#Accepted on Leetcode

#Approach
#Divide the problem into subproblems 
#Each subproblem's solution is = min(picking the current coin and adding to amount, not picking the current coin and moving onto the next one)
#Create a 2D array to store solutions of previously solved subproblems, add dummy rows to mimic base cases
#Iterate through array bottom's up and find solution to each subproblem by taking minimum of previous subproblems
#Solution to the entire problem will be the last row of the last column

class Solution:

    #Recursive solution without memoization

    # def coinChange(self, coins: List[int], amount: int) -> int:
    #     dp = [[float('-inf') for j in range(amount+1)] for i in range(len(coins))]

    #     soln = self.findMinChange(coins, len(coins) - 1, amount, dp)
    #     return -1 if soln == float('inf') else soln


    #Iterative solution with tabulation
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[float('inf') for j in range(amount + 1)] for i in range(len(coins) + 1)]

        for i in range(len(coins) + 1):
            dp[i][0] = 0

        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                dp[i][j] = dp[i-1][j] if j < coins[i-1] else min (dp[i-1][j], dp[i][j - coins[i-1]] + 1)
        
        soln = dp[len(coins)][amount]

        return soln if soln != float('inf') else -1 


    #Recursive solution with memoization    
    def findMinChange(self, A, i, amount, dp):
        if amount == 0:
            return 0
        if i < 0  or amount < 0:
            return float('inf')
        
        if dp[i][amount] != float('-inf'):
            return dp[i][amount]
        else:
            dp[i][amount] = min (self.findMinChange(A, i -1 , amount, dp), self.findMinChange(A, i, amount - A[i], dp) + 1)
            return dp[i][amount]


