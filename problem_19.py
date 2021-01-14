class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        return self.helper_function(coins,amount,0,0)
    def helper_function(self,coins,amount,i,min_coins): #min is miimum coins
        if (amount < 0) or (i > (len(coins) -1)):
            return -1
        elif amount == 0:
            return min_coins
        case1 = self.helper_function(coins,amount-coins[i],i,min_coins+1) #this if the coin is to be included
        case2 = self.helper_function(coins,amount,i+1,min_coins) #this if we have to move to next     #coin
        if case1 == -1:
            return case2
        elif case2 == -1:
            return case1
        else:
            return min(case1,case2)



