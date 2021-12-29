class MemoisedRecursion:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        def recur(target, memo):
            if target < 0:
                return -1
            
            if target == 0:
                return 0
            
            if target in memo:
                return memo[target]
            
            minCoins = -1
            for coin in coins:
                numCoins = recur(target - coin, memo)
                if numCoins != -1:
                    numCoins += 1
                    if minCoins == -1 or numCoins < minCoins:
                        minCoins = numCoins
            
            memo[target] = minCoins
            return memo[target]
        
        
        
        
        return recur(amount, {})

class DynamicProgramming:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        dp = [(amount + 1)] * (amount + 1)
        dp[0] = 0
        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] = min(dp[i], dp[i - coin] + 1)
        
        if dp[-1] == (amount + 1):
            return -1
        else:
            return dp[-1]