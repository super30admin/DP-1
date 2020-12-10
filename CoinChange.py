# DP solution
# Time complexity : O(A*n) ; A = amount and n = number of coins
# Space complexity : O(A) ; A = amount (fill up the table)
# Approach : Here we build up the table to remember sub problems calculation, so that we don't do repetative calculations like we do in recursive approach. We build up the table considering every amount for all combinations of coins, taking minimum through all iterations. Our solution lies in last row and last column.
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not coins or len(coins) == 0:
            return -1
        
        dp = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]
        
        m = len(dp)
        n = len(dp[0])
        
        for i in range(n):
            dp[0][i] = amount + 1
        
        for i in range(1, m):
            for j in range(1, n):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])
        
        return dp[m - 1][n - 1] if dp[m - 1][n - 1] != amount + 1 else -1
                

# Recursive solution : Time Limit Exceeded
# class Solution:
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         if not coins or len(coins) == 0:
#             return -1
        
#         return self.helper(coins, amount, 0, 0)
    
#     def helper(self, coins, amount, index, minCoins):
#         # Base
#         if amount == 0:
#             return minCoins
        
#         if index == len(coins) or amount < 0:
#             return -1
        
#         # Logic
#         # Choose the coin
#         case1 = self.helper(coins, amount - coins[index], index, minCoins + 1)
        
#         # Don't choose the coin
#         case2 = self.helper(coins, amount, index + 1, minCoins)
        
#         if case1 == -1:
#             return case2
#         if case2 == -1:
#             return case1
        
#         return min(case1, case2)