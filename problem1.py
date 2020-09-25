def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [0]*(amount+1)
        for i in range(1, amount+1):
            if i in coins:
                dp[i] = 1
                continue
            min_coins = float("inf")
            for coin in coins:
                if i-coin >= 0:
                    min_coins = min(dp[i-coin], min_coins)
            dp[i] = min_coins+1
        if dp[-1] == float("inf"):
            return -1
        return dp[-1]
        
        #tc --> o(mn)
        #sc --> o(n)
        #m = length of the coins array
        #n = amount
