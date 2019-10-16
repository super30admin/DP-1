class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        highval_coin = 0
        total_coins = 0
        difference = 0
        n = len(coins)
        if amount == 0:
            return 0        
        if n==0:
            return -1
        elif sum(coins) == amount:
            return n
        elif n == 1:
            for i in range(1,5):
                difference = amount - coins[0]*i
                if difference > 0 and difference in coins:
                    return i + 1
                elif difference > 0 and difference not in coins:
                    return -1
                else:
                    return -1
        else:
            highval_coin = max(coins)        
            for i in range(1,5):
                difference = amount - highval_coin*i
                if difference > 0 and difference in coins:
                    return i + 1
                elif difference > 0 and difference not in coins:
                    continue
                else:
                    return -1
        return total_coins
        
        