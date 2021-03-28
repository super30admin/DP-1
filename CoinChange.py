class Solution(object):
    def __init__(self):
        self.mem = {}
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        out = self.calculateChange(coins,amount)
        if(out == sys.maxint):
            return -1
        return out
    
    # Solution using Memoization, Top Down approach, storing the output of each computation in memory
    # Time Complexity is O(amount*NoOfCoins) and Space Complexity is O(amount)
    
    def calculateChange(self,coins,amount):
        if(amount in self.mem):
            return self.mem[amount]
        if(amount == 0):
            return 0
        # For every coin we have two options pick a coin or not pick a coin
        minCoins = sys.maxint
        for coin in coins:
            if(amount - coin >=0 ):
                minCoins = min(minCoins,1+self.calculateChange(coins,amount-coin))
        self.mem[amount] = minCoins
        return minCoins