class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # #recursive gives TLE due to exhaustive trees computatio
        if not coins:
            return 0
        # def helper(coins,amount,index,coinsum):
        #     #if condition met return no. of coins
        #     if amount==0:
        #         return coinsum
        #     #if amount becomes negative or index goes out of bound
        #     if (amount<0 or index==len(coins)):
        #         return -1
        #     #take coin> reduce amount required and increase cont of coin taken
        #     case1=helper(coins,amount-coins[index],index,coinsum+1)
        #     #skip coin, continue from next coin index
        #     case2=helper(coins,amount,index+1,coinsum)
        #     #if any case fails run and return another case
        #     if case1==-1:
        #         return case2
        #     if case2==-1:
        #         return case1
        #     #if both cases run, return minimum no. of coins required
        #     return min(case1,case2)
        # #call recursive function from main
        # return helper(coins,amount,0,0)
        
        
        #DP
        #O(N) #coins length<=12
        #O(N)  #amount<10^4
        #calculating for all amountvalues from 0 to end>>to get amount 0, choose any coin zero times>>.thatswhy initial 0 and then infinite
        dp = [0] + [float('inf') for i in range(amount)]
        #start calculating from 1st amountvalue
        for i in range(1, amount+1):
            #for coin values(1,2,5)
            for coin in coins:
                #if that amount is reachable by coin, then only go forward
                if i - coin >= 0:
                    #for every coin denomination>>find dp[remaining amount] and add 1 to it as everything is in sequence.#store miniumum value amongst all coins answers
                    dp[i] = min(dp[i], dp[i-coin] + 1)
        if dp[-1] == float('inf'):
            return -1
        #return last value
        return dp[-1]