class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [0]+[float('inf') for i in range(amount)]
        for i in range(1, amount+1):
            for coin in coins:
                if i-coin>=0:
                    dp[i]=min(dp[i],dp[i-coin]+1)
        if dp[-1] == float('inf'):
            return -1
        return dp[-1]


# recursion with  memoization
# class Solution:
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         fewestCoins = self.fewestCoins(coins, amount, dict())
        
#         return fewestCoins if fewestCoins < float('inf') else -1
    
#     def fewestCoins(self, coins, amount, memo):
#         if amount < 0:
#             return float('inf')
#         elif amount == 0:
#             return 0
#         else:
#             if amount not in memo:
#                 memo[amount] = 1 + min([self.fewestCoins(coins, amount-c, memo) for c in coins])
#             # print(memo)
#             return memo[amount]