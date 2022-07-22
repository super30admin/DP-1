class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # Best space optimized DP TC - O(n*amount) SC - O(amount)
        dp = [float('inf') for _ in range(amount + 1)]
        dp[0] = 0
        for coin in coins:
            for j in range(1, amount + 1):
                if coin <= j:
                    dp[j] = min(dp[j], 1 + dp[j - coin])
        return dp[amount] if dp[amount] != float('inf') else -1

    '''
        # DP TC - O(n*amount) SC - O(n*amount)
        n = len(coins)
        dp = [[0]*(amount+1) for _ in range(n+1)]

        for j in range(amount+1):
            dp[0][j] = float('inf')

        for i in range(n+1):
            dp[i][0] = 0

        for i in range(1,n+1):
            for j in range(1,amount+1):
                if coins[i-1] <= j:
                    # min(no choose, choose coins[i-1])
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]])
                else:
                    # no choose because amount < 0
                    dp[i][j] = dp[i-1][j]

        return dp[n][amount] if dp[n][amount] != float('inf') else -1
        # return dp[n][amount] gives wrong anser (inf) for input [2] amount = 3.... expected -1
    '''

    ''' # not working below
        # Memoization - Recursion + storage
        n = len(coins)
        t = [[-1]*(n+1) for _ in range(amount+1)]

        return self.coinHelper(coins,amount,n,t)

    def coinHelper(self,coins,amount,n,t):
        if amount == 0:
            return 0

        if n == 0 or amount < 0:
                return -1

        elif t[n][amount] != -1:
            return t[n][amount]

        # choose
        t[n][amount] = 1 + self.coinHelper(coins,amount-coins[n-1],n,t)
        #t[n-1][amount-coins[n-1]] = 
        # no choose
        #t[n-1][amount]
        t[n][amount] = self.coinHelper(coins,amount,n-1,t)

        return t[n][amount]

    '''

    '''
        def coinHelper(coins,amount,n,min_coins):
            # Recursion - Time Limit Exceed
            # TC = O(2**(more than n)) because we can repeat the coins
            #base
            if amount == 0:
                return min_coins
            if n == 0 or amount < 0:
                return -1

            #logic
            # choose
            case1 =  coinHelper(coins,amount-coins[n-1],n,min_coins+1) 
            # no choose
            case2 =  coinHelper(coins,amount,n-1,min_coins)

            if case1 == -1:
                return case2
            elif case2 == -1:
                return case1
            return min(case1,case2)

        n= len(coins)
        min_coins = 0
        return coinHelper(coins, amount, n, min_coins)     
    '''


