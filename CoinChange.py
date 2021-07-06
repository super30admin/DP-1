CoinChange:
"""
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Note:
You may assume that you have an infinite number of each kind of coin.
"""

Time Complexity : O(numCoins * Amount)  
Space Complexity : O(numCoins * Amount) 
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        #Forming the header for the matrix with the length of amount and coin
        dp = [[i for i in range(amount + 1)] for i in range(len(coins) + 1)]
    
        # Fill the First Column with all zeros
        for i in range(len(coins) + 1):
            dp[i][0] = 0
        # Fill the row with amount + 1
        for j in range(amount + 1):
            dp[0][j] = amount + 1

        for rowCoin in range(1, len(coins) + 1):
            for colAmount in range(1, amount + 1):
                if colAmount < coins[rowCoin - 1]:
                    dp[rowCoin][colAmount] = dp[rowCoin - 1][colAmount]
                else:# when my denomination is greater than the amount,calculate min (previous value in the matrix and current one )
                    dp[rowCoin][colAmount] = min(dp[rowCoin - 1][colAmount],
                                                      1 + dp[rowCoin][colAmount - coins[rowCoin - 1]])

        minCoins = dp[len(coins)][amount]
        if minCoins > amount + 1:
            return -1

        return minCoins
