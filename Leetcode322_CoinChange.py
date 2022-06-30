class Solution:
    def coinChange(self, coins, amount: int) -> int:
        coins.sort(reverse=True)
        self.result=float("inf")
        def dfs(largest_coin, remainder, used_coins):
            if remainder==0:
                self.result==min(self.result, used_coins)
                
            for i in range(largest_coin,len(coins)):
                if remainder>=coins[i]*(self.result-used_coins):
                    break
                if coins[i]<=remainder:
                    dfs(i,remainder-coins[i], used_coins+1)
        dfs(0, amount, 0)
        return self.result if self.result!=float("inf") else -1