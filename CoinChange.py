class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if not coins:
            return 0
        '''
        self.res = float('inf')
        def helper(coins,amount,i,totalCoins):
            #base case, if amount is negative or we run out of options.
            if amount < 0 or i == len(coins):
                return
            
            if amount == 0:
                # we have a certain set of combinations that match.
                # see if it is the best combination available.
                self.res = min(self.res, totalCoins)
                return
            # 2 options now, choose or dont choose
            #dont choose
            helper(coins,amount,i+1,totalCoins)

            #choose
            helper(coins,amount - coins[i], i, totalCoins + 1)

        helper(coins,amount,0,0)

        if self.res != float('inf'):
            return self.res
        return -1
        '''

        dp = [999999] * (amount + 1)

        dp[0] = 0

        #for i in range(1,len(dp[0])):
        #    dp[0][i] = 999999

        for i in range(0, len(coins)):
            for j in range(1, len(dp)):
                # if we do not have an option to choose,
                # then consider the don't choose value.
                # it is nothing but the value in the same column,
                # one row above
                #if j < coins[i-1]:
                #    dp[i][j] = dp[i-1][j]
                #else:
                    # the best option would be minimum of don;t choose
                    # and choose
                    # choose is nothing but 1 + dp[i][j - coints[i-1]]. Why?
                    # because 1 indicates we are choosing the coin in the current instance,
                    # dp[i][j - coins[i-1]] indicates the value of the subrpoblem where 
                    # coins are the same, but amount is reduced as we chose coin for the first
                    # time (we can choose the coins unlimited number of times.)
                #print(i, dp, j)
                if j >= coins[i]:
                    dp[j] = min(dp[j], 1 + dp[j - coins[i]])

        if dp[-1] == 999999:
            return -1
        return dp[-1]

    #TC : O(m*n)