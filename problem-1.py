# // Time Complexity : O(m*n) m = len(coins) , n = amount
# // Space Complexity : O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :



from typing import List
#dp solution
def coinChange(coins: List[int], amount: int) -> int:
    m = len(coins)
    n = amount
    
    dp = [[0] * (n+1) for _ in range(m+1)]
    
    for _ in range(1, n+1):
        dp[0][_] = amount + 1
    
    # print(dp) 
    
    for i in range(1, m+1):
        for j in range(1, n+1):
            if j < coins[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])
    
    if dp[m][n] == amount + 1:
        return -1
    return dp[m][n]
    
    
#recursive solution
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         return self.helper(coins, amount, 0, 0)
    
#     def helper(self, coins: List[int], amount: int, index: int, coinsUsed: int):
#         #base case
#         if (index == len(coins) or amount < 0 ):
#             return -1
#         if(amount == 0):
#             return coinsUsed
        
#         #logic
#         #case 0 - do not choose a coin
#         case0 = self.helper(coins, amount, index+1, coinsUsed)
        
#         #case 1 - choose the current coin
#         case1 = self.helper(coins, amount - coins[index], index, coinsUsed + 1)
        
#         if(case0 == -1):
#             return case1
#         if(case1 == -1):
#             return case0
        
#         return min(case0, case1)


coins = [1,2,5]
amount = 11

print(coinChange(coins, amount))