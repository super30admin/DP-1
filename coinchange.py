class Solution:
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # complexity: Time : O(amount*coins) Space: O(amount)
        
        x = [float("inf") for i in range(0,amount)]
        coins.sort()
        for i in coins:
            if(i>amount):
                continue
            if(i==amount):
                return 1
            else:
                x[i-1] = 1
        if(amount==0):
            return 0
        
        for i in range(0,amount):
            if(x[i]<float("inf")):
                continue
            min1 = float("inf")
            for j in range(0,len(coins)):
                if(coins[j]-1>i):
                    break
                
                if(1 + x[i-coins[j]]<min1):
                    min1 = 1+ x[i-coins[j]]
            
            x[i] = min1
        
        if(x[-1]==float("inf")):
            return -1
        else:
            return x[-1]
