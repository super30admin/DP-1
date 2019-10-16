class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        highval_coin = 0
        total_coins = 0
        difference = 0
        n = len(coins)
        if n==0:
            return -1
        elif n==1 and coins[0] < amount:
            return -1            
        highval_coin = max(coins)        
        for i in range(1,n):
            difference = max(highval_coin*i, amount) - min(highval_coin*i, amount)
            if difference in coins:
                total_coins = i + 1
                break
        return total_coins
        
        