
# Dynamic Programming
# passed all test cases
# time complexity =O(m*n)
#space complexity=O(N)
class Solution(object):
    def coinChange(self, coins, amount):
        dp = [[None] * (amount + 1) for _ in  range(len(coins) + 1) ] # amount+1 is columns and lem(coins)+1 is rows
        # a = [[0] * m] * n
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        #print(len(dp))
        m = len(dp)  # rows = len(coins)+1
        n = len(dp[0])  # columns
        for i in range(m):

            dp[i][0] = 0  # for initialising the first column of dp matrix to 0 (0 to len(coins)
            # rows)
            #print('----',dp)
            i += 1
        #print('ppppp---', dp)
        for i in range(n):  # 0 to amount rows
            #print('nnnn--', dp)
            dp[0][i] = 99999  # initialising it to infinity not pssible so set it ---?why is evrything getting replaced
            # some large value
            i += 1
        #print('ppppppppmmmm---', dp)
        for i in range(1, m):  # for each row and start with 1 to m as value
            # corresponding to 0 is

            # filled with 99999
            #print('iiiiii', dp)
            for j in range(1, n):  # for each column and start with 1 to n as 1st
                # column is filled with 0
                #print('ijijijij---', dp)
                if j < coins[i - 1]:
                    # condition when the coins greater than amount
                    # by defaut consider previous coins values
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])
                    # case when we add new coin
                j += 1
                #print('jjjjjjjjj---', dp)
            i += 1
        result = dp[m - 1][n - 1]  # index starts with 0
        if result >= 99999:  # cases when we add 1 then 99999 is taken for infinoty
            return -1
        return result

l= Solution()
l.coinChange([1,2,5],11)
