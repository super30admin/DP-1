class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        def c_change(coins,amount,count):
            if amount==0:
                return count
            elif amount>0 and len(coins)==0:
                return -1
            elif amount>=coins[-1]:
                return c_change(coins,amount-coins[-1],count+1)
            else:
                return c_change(coins[:-1],amount,count)
            
        coins = sorted(coins) 
        return c_change(coins,amount,0)