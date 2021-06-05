#Time complexity: O(m*n)   
#Space complexity: O(m*n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # Making 2d array of size len(coins)+1 amount+1
        dp = [[0]*(amount+1)]*(len(coins)+1)

        #dummy row initialization
        # first row would have random value, any value above the amount
        for idx in xrange(1,len(dp[0])):
            dp[0][idx] = amount+1

        # iterating over the dp matrix
        for i,row in enumerate(dp):
            for j,el in enumerate(dp[0]):
                # if the index of column is less than the coin denom
                # copy the value from above
                if j<coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                # if the amount is greater than the coin denom
                # then the value would be min of value above and value of coin steps before +1
                else:
                    dp[i][j] = min(dp[i-1][j],dp[i][j-coins[i-1]]+1)

        #the last entry which means all denom's considered and the target amount would give the min 
        #number of coins required to reach that amount
        # if greater than the amount, not valid, otherwise return that last entry
        if dp[-1][-1]>amount:
            return -1
        
        return dp[-1][-1]