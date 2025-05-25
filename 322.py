class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        minCoins =  self.dpdp(coins, amount)
        if minCoins >=999999:
            return -1
        return minCoins

    def dpdp(self,coins, amount):
        dp = [[0]*(amount+1) for _ in range(len(coins)+1)]
        '''dp
          0  1  2  3  4  5  6  7  8  9 10 11
        0 0 99 99 99 99 99 99 99 99 99 99 99
        1 
        2
        5
        '''
        choices = []
        dp[0][0] = 0
        for j in range(1,len(dp[0])):
            dp[0][j] = 999999
        for i in range(1,len(dp)):
            for j in range(len(dp[i])):
                denomination = coins[i-1]
                amount = j
                if denomination>amount:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-denomination])
        
        return dp[-1][-1]

    # def recursive(self, coins, idx, amount):
    #     if amount == 0 :
    #         return 0
    #     if amount < 0 or idx == len(coins):
    #         return 9999
    #     case1 = 1 + self.coins(coins, idx, amount-coins[idx]) # use coin
    #     case2 = self.coins(coins, idx+1, amount) # dont use, use next coin

    #     return min(case1, case2)
        
