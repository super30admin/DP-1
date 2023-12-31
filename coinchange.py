#Included Recursion, Recursion with Memoization, DP Tabulation Solutions



class Solution:
    # def findC(self, ind, coins, amount, memo):
        
# Recursion
#         if amount == 0:
#             return 0
        
#         if len(coins) == ind or amount < 0:
#             return float('inf')
        
#         case1 = 1 + self.findC(ind, coins, amount - coins[ind])
#         case2 = self.findC(ind + 1, coins, amount)
        
#         return min(case1, case2)

# Recursion with Memoization
        
#         if (ind, amount) in memo:
#             return memo[(ind, amount)]
        
#         if amount == 0:
#             return 0
        
#         if len(coins) == ind or amount < 0:
#             return float('inf')
        
#         case1 = 1 + self.findC(ind, coins, amount - coins[ind], memo)
#         case2 = self.findC(ind + 1, coins, amount, memo)
        
#         memo[(ind, amount)] = min(case1, case2)
        
#         return memo[(ind, amount)]
    
    
     
    def coinChange(self, coins: List[int], amount: int) -> int:
        
#         memo = {}
#         result = self.findC(0, coins, amount, memo)
        
#         return -1 if result == float('inf') else result

        dp = [float('inf') for _ in range(amount + 1)]
    
        dp[0] = 0
        
        for a in range(1, amount+1):
            
            for coin in coins:
                
                if coin <= a:
                    
                    dp[a] = min(dp[a], 1 + dp[a - coin])
                    
                    
        return -1 if dp[-1] == float('inf') else dp[-1]
