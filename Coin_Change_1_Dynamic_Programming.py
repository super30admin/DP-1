# Created by Aashish Adhikari at 5:29 PM 1/5/2021

'''
Time Complexity:
O(amount * no of coins)

Space Complexity:
O(amount * no of coins)

'''

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """

        assert len(coins)

        r = [999999. for idx in range(amount + 1)]
        dp = [r for idxx in range( len(coins)+1) ]


        # first row already filled with 99999.


        # fill the first column
        for idx in range(0, len(dp)):
            dp[idx][0] = 0


        # fill all other elements
        for row in range(1, len(dp)):

            for col in range(1, len(r)):

                if col < coins[row-1]:
                    dp[row] [col] = dp[row-1] [col]
                else:
                    dp[row][col] = min (dp[row-1][col], dp[row][col - coins[row-1]] + 1)


        # if this amount cannot be made, then we will be copying 999999. from above rows until the end
        if dp[-1][-1] >= 999999.:
            return -1
        return dp[-1][-1]