class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = [0] * (amount + 1)
        for i in range(1, amount + 1):
            dp[i] = amount + 1
        for i in range(1, amount + 1):
            for coin in coins:
                if i - coin < 0: continue
                dp[i] = min(dp[i], dp[i - coin] + 1)

        if dp[amount] != amount + 1:
            return dp[amount]
        else:
            return -1

        # Brute Force
        """
        def helper(coins, amt, coinsused):
            if amt <0 or (not coins): return -1
            if amt==0: return coinsused
            #not to use the coin
            case1 = helper(coins[1::], amt, coinsused)

        #using the coin
            case2 = helper(coins, amt-coins[0], coinsused+1)

            if case1==-1: return case2
            elif case2==-1: return case1
            return min(case2,case1)
        return helper(coins,amount,0)
"""











