class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        #dynamic programming- Bottom up
        # since we are considering zero as well for columns
        cols = amount + 1
        rows = len(coins)
        DP = [[0 if col == 0 else float ("inf") for col in range(cols)] for row in range(rows)]
        
        for i in range(rows):
            for j in range(1, cols):
                if coins[i] > j:
                    DP[i][j] = DP[i-1][j]
                else:
                    DP[i][j] = min(1+DP[i][j-coins[i]],DP[i-1][j])
        
        if DP[rows-1][cols-1] != float ("inf"):
            return DP[rows-1][cols-1] 
        else:
            return -1
            
        
        
        
        #Recursion
        # if amount <= 0:
        #     return 0
        # ans = float('inf')
        # for i in range(len(coins)):
        #     if amount - coins[i] >= 0:
        #         x = self.coinChange(coins,amount - coins[i])
        #         if x != -1:
        #             ans = min(ans , 1 + x)
        # return -1 if  ans == float('inf') else ans
        
        
#         #set the deafult value to amount
#         min_coins='inf'
#         #base case
#         if amount in coins:
#             return 1
        
#         #recursion
#         for i in [c for c in coins if c<=amount]:
#             num_coins = 1+self.coinChange(coins, amount-i)
            
#             if num_coins < min_coins:
#                 min_coins=num_coins
            
#         if min_coins == 'inf':
#             return -1
#         else:     
#             return min_coins
        
        