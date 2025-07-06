'''
322. Coin Change
'''

# Time Complexity : 
# Space Complexity : 
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this :

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # Using Recursion
        # def coinChangeHelper(i, amount):
        #     if amount == 0:
        #         return 0
        #     if amount < 0 or i < 0:
        #         return float('inf')
        #     # We can either take the current coin or skip it
        #     take = 1 + coinChangeHelper(i, amount - coins[i]) # Take the coin
        #     skip = coinChangeHelper(i - 1, amount) # Skip the coin
        #     return min(take, skip) # Return the minimum of the two options
        # result = coinChangeHelper(len(coins) - 1, amount)
        # return result if result != float('inf') else -1 # If we cannot make the amount, return -1
    
        # Using Dynamic Programming
        dp = [float('inf')] * (amount + 1) # Create a dp array to store the minimum coins needed for each amount
        dp[0] = 0 # Base case, 0 coins needed to make amount 0
        for coin in coins: # Iterate through each coin
            for j in range(coin, amount + 1): # Iterate through each amount from coin to the target amount
                dp[j] = min(dp[j], dp[j - coin] + 1) # Update the dp array with the minimum coins needed
        return dp[amount] if dp[amount] != float('inf') else -1 # If we cannot make the amount, return -1

# Visualizing the Dry Run:
# coins = [1, 2, 5], amount = 11
# dp = [0, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf]
# After processing coin 1:
# dp = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
# After processing coin 2:
# dp = [0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7]
# After processing coin 5:
# dp = [0, 1, 1, 2, 2, 3, 1, 2, 2, 3, 3, 4, 2, 3, 3]
# The final answer is dp[11] = 3, which means we need 3 coins to make the amount 11 (5 + 5 + 1).
## Visualizing the DP Table:
# | Amount | Coins Used |
# |--------|-------------|
# | 0      | 0           |
# | 1      | 1           |
# | 2      | 1           |
# | 3      | 2           |
# | 4      | 2           |
# | 5      | 1           |
# | 6      | 2           |
# | 7      | 2           |
# | 8      | 3           |
# | 9      | 3           |
# | 10     | 2           |
# | 11     | 3           |
# The table shows the minimum number of coins needed to make each amount from 0 to 15. The final answer is found in the last row, which indicates that we need 3 coins to make the amount 11. If the amount cannot be made with the given coins, the value will be 'inf', and we return -1.