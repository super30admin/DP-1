# Time Complexity: O(m*n)
# Space Complexity: O(m*n)

# --------------------------DP Approach----------------------------
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0 or coins is None:
            return -1
                     
        m = len(coins)+1
        n = amount+1
        dp = [[0]*n]*m
        
        for j in range(1, n):
            dp[0][j] = amount + 1
        
        for i in range(1,m):
            for j in range(1,n):
                if j<coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                    
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j-coins[i-1]])
        
        if dp[m-1][n-1] == amount + 1: dp[m-1][n-1] = -1
        return dp[m-1][n-1]
                         

# -----------------------Exhaustive Approach-----------------------
# class Solution:
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         if len(coins) == 0 or coins is None:
#             return -1
#         return self.helper(coins, 0, amount, 0)
        
    
#     def helper(self, coins, index, amount, min_coins):
#         if index == len(coins) or amount < 0:
#             return -1
#         if amount == 0: return min_coins
        
#         case0 = self.helper(coins, index + 1, amount, min_coins)
        
#         case1 = self.helper(coins, index, amount - coins[index], min_coins +1)
        
#         if case0 == -1: return case1
#         if case1 == -1: return case0
#         return min(case0, case1)