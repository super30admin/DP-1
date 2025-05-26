# #Approach-1:Recursive Coin Change - Choose/Not Choose - Exponential
# #TC: O(2^n)
# #SC: 
# class Solution:
#     """
#     1. Start from the first coin and try all possibilities to form the target amount.
#     2. At each step:
#        - Either include the current coin (stay at the same index, subtract coin value, add to coin count).
#        - Or exclude the current coin (move to the next index, coin count unchanged).
#     3. Continue recursively until:
#        - The remaining amount becomes 0 → valid solution, return coin count.
#        - The remaining amount becomes negative or no more coins left → invalid path.
#     4. Return the minimum number of coins among all valid paths, or -1 if none work.
#     """
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         # Start the recursive helper with:
#         # - full amount to reach
#         # - starting from first coin (index 0)
#         # - 0 coins used so far
#         return self.helper(coins, amount, 0, 0)

#     def helper(self, coins, remainingAmount, coinIndex, currentNumberOfCoins):
#         # Base case: If amount is negative or we've used all coins — invalid path
#         if remainingAmount < 0 or coinIndex >= len(coins):
#             return -1

#         # Found a valid combination that sums to the amount
#         if remainingAmount == 0:
#             return currentNumberOfCoins

#         # Case 1: Don't choose and move to the next
#         noOfCoinsCase1 = self.helper(coins, remainingAmount, coinIndex + 1, currentNumberOfCoins)

#         # Case 2: Choose coin (stay at same index, subtract its value)
#         noOfCoinsCase2 = self.helper(coins, remainingAmount - coins[coinIndex], coinIndex, currentNumberOfCoins + 1)

#         # Combine results:
#         # If one branch failed, return the other; if both worked, return the minimum
#         if noOfCoinsCase2 == -1:
#             return noOfCoinsCase1
#         if noOfCoinsCase1 == -1:
#             return noOfCoinsCase2
#         return min(noOfCoinsCase1, noOfCoinsCase2)


# Approach2: DP 2D Array: Tabulation
# Time: O(n * amount) — n is number of coins
# Space: O(n * amount) — due to 2D DP table
class Solution:
    def coinChange(self, coins, amount):
        # Initialize a 2D DP matrix with (len(coins)+1) rows and (amount+1) columns
        # dp_matrix[i][j] will represent the minimum number of coins needed to make amount 'j'
        # using the first 'i' coins
        dp_matrix = [[None for i in range((amount + 1))] for j in range(len(coins) + 1)]

        # Base case: 0 coins are needed to make amount 0 (fill first column with 0)
        for i in range(len(coins) + 1):
            dp_matrix[i][0] = 0

        # Base case: When we have 0 coins and non-zero amount, it's impossible — use a large value
        for j in range(1, len(dp_matrix[0])):
            dp_matrix[0][j] = float('inf')  # 9999: acts like infinity

        # Fill the DP matrix
        for i in range(1, len(dp_matrix)):  # i represents the coin index
            for j in range(1, len(dp_matrix[0])):  # j represents the current target amount
                if j < coins[i - 1]:
                    # If the coin value is more than current amount, we can't include this coin
                    # So take the result from the previous row (exclude this coin)
                    dp_matrix[i][j] = dp_matrix[i - 1][j]
                else:
                    # Either exclude the coin (dp[i-1][j])
                    # Or include the coin: 1 + result of solving for amount (j - coin value)
                    dp_matrix[i][j] = min(dp_matrix[i - 1][j], dp_matrix[i][j - coins[i - 1]] + 1)
        # The final answer is in the bottom-right corner of the matrix
        # If it's still 99999 (unreachable), return -1
        if dp_matrix[-1][-1] >= float('inf'):
            return -1
        return dp_matrix[-1][-1]

# #Approach3: 1D DP
# #Time: O(n * amount) where n = len(coins)
# #Space: O(amount) — just one 1D array
# class Solution:
#     '''
#     •	dp[j] = minimum number of coins needed to make amount j
# 	•	Loop over each coin, and for that coin, update the DP array
# 	•	1 + dp[j - coin] means: use current coin once, then solve for the rest (j - coin)
# 	•	Final answer is dp[amount] if reachable, else -1
#     '''
#     def coinChange(self, coins, amount):
#         # Initialize dp array: dp[j] = min coins to make amount j
#         dp = [float('inf')] * (amount + 1)
#         dp[0] = 0  # 0 coins needed to make amount 0

#         for coin in coins:
#             for j in range(coin, amount + 1):
#                 # If we can reach amount j - coin, we can try using this coin
#                 dp[j] = min(dp[j], 1 + dp[j - coin])

#         return -1 if dp[amount] == float('inf') else dp[amount]
