# // Time Complexity : m - no of coins, n - amount; grredy - not possible, exhausitve o(2^m+n) , DP memoi and tabulation :2D matix botttom up and top down - o(m*n) 
# // Space Complexity : same as time complexity
# // Did this code successfully run on Leetcode : exhaustive TLE ; yes for other two approaches
# // Any problem you faced while coding this : 
#  coming up with exhaustive sol timcomplexity and intuition behind top down and bottom up approach 


# // Your code here along with comments explaining your approach
# 1) exhaustive try all thee comination include a coin not include a coin and take the min of the results but handle base cases
# 2) tabulation bottom up- create a m*n matrix initialixe the matrxi and again apply the same as recursion
#  3) faced issue with memoizations while defining 2d array

# Approach 1
from typing import List
# class Solution:
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         res = self.helper(coins, 0, amount)
#         return -1 if res > amount else res
    
#     def helper(self, coins, idx, amount):
#         if amount == 0: return 0
#         if amount < 0 or idx>= len(coins) : return 10**1000
#         # dont choose coin
#         res1 = self.helper(coins, idx+1, amount)
#         # choose coinm
#         res2 = 1 + self.helper(coins, idx, amount-coins[idx])
#         return min(res1, res2)

# Approach 2 bottom up or tabulation:
# class Solution:
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         m = amount
#         n = len(coins)
#         dp = [[ None for j in range(m+1)] for _ in range(n+1)]
#         dp[0][0] = 0
#         for j in range(1,m+1):
#             dp[0][j] = amount+2
#         for i in range(1, n+1):
#             for j in range(m+1):
#                 # amount is less than the coin denomination
#                 if j < coins[i-1]:
#                     dp[i][j] = dp[i-1][j]
#                 else:
#                     dp[i][j] = min(dp[i-1][j], 1 + dp[i][j-coins[i-1]])
#         return -1 if dp[n][m] > amount+1 else dp[n][m] 

# Approach 3 memo

# class Solution:

#     def coinChange(self, coins: List[int], amount: int) -> int:
#         memo = [[-1 for _ in range(amount + 1)] for _ in range(len(coins))]
#         def helper(coins, idx, amount):
#             if amount == 0: return 0
#             if amount < 0 or idx>= len(coins) : return float('inf')
#             # dont choose coin
#             if memo[idx][amount] != -1 : return memo[idx][amount]
#             res1 = helper(coins, idx+1, amount)
#             # choose coin
#             res2 = 1 + helper(coins, idx, amount-coins[idx])
#             memo[idx][amount] = min(res1, res2)
#             return memo[idx][amount]

#         res = helper(coins, 0, amount)
#         return -1 if res == float('inf') else res
    

# Approach 4 : using 1d aray
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount + 1] * (amount+1)
        dp[0] = 0
        for i in range(1, amount+1):
            for j in range(len(coins)):
                if i < coins[j]:
                    dp[i] = dp[i]
                else:
                    dp[i] = min(dp[i], 1+dp[i - coins[j]])
        return dp[amount] if dp[amount] != amount+1 else -1

        


        


        
