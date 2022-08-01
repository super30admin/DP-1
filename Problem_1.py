"""
Time Complexity : Inside function
Space Complexity : Inside function
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes


Your code here along with comments explaining your approach

Problem_1: Coin Change, You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
"""

# Approach - 1 : Greedy
class Solution:
        
    def coinChange(self, coins: List[int], amount: int) -> int:
        """
        This is the exhaustive approach, where we will consider each and every possible outcome
        Time Complexity : O(2^n), where n is the level of a tree
        Space Complexity : O(n)
        
        """
        if len(coins) == 0 or coins == None:
                return 0
        return self.helper(coins, amount, 0, 0)
            
        
    def helper(self,coins, amount, index, coins_used):
        #Base case
        if amount == 0:
            return coins_used
        
        if (index == len(coins) or amount < 0):
            return -1
        
        # case -1 : choose a coin
        case_1 = self.helper(coins, amount - coins[index], index, coins_used + 1 )
        
        
        # case - 2 : not choose a coin
        case_2 = self.helper(coins, amount, index + 1, coins_used)
        
        if case_1 == -1 : return case_2
        if case_2 == -1 : return case_1
        
        return min(case_1, case_2)
            

# Approach - 2 : Dynamic programming (bottom-up)
class Solution_1:
    def coinChange(self, coins, amount) -> int:
        """
        We will take the matrix of the coins and amount, considereing the cases in exhaustive approach.
        we will not calculate the repetitve results again rather, take it from the prev calculations
        Time Complexity : O(m * n ), where m and r are the numer of coins and total amount
        Space Complexity : O(n * m)
        """
        if len(coins) == 0 or coins == None:
                return 0
        m = len(coins)
        n = amount
        dp = [[0 for i in range(n+1)] for j in range(m+1)]
        dp[0][0] = 0
        
        
        for i in range(1, len(dp[0])):
            dp[0][i] = amount + 1
        
        for i in range(1,len(dp)):
            for j in range(1, len(dp[0])):
                #check if the amount is less than the coin denomination
                if (j < coins[i - 1]):
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j],1 + dp[i][j - coins[i - 1]])
                   
        res = dp[m][n]
        if res > amount : return -1
        
        return res

# Approach - 2 : Dynamic programming (bottom-up) space optimised
class Solution_2:
    def coinChange(self, coins, amount) -> int:
        """
        Rather than taking 2D array, we will store the result in 1D array.
        Time Complexity : O(m * n ), where m and n are the numer of coins and total amount
        Space Complexity : O(n)
        """
        if len(coins) == 0 or coins == None:
                return 0
        dp = [(amount + 1)] *(amount + 1)
        dp[0] = 0
        for value in coins:
            for i in range(value, amount + 1):
                dp[i] = min(dp[i], dp[i - value] + 1)
        if dp[amount] > amount:
            return -1
                
        return dp[amount] 