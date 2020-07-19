# Time Complexity O(n*k) where k is the amount
#SPace Complexity O((n+1) * (k+1)) where n is length of coins and k is the amount
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        d = [[0] * (amount+1)] * (len(coins) + 1)
        for i in range(0,amount+1):
            d[0][i] = 999999

        for j in range(0,len(coins)+1):
            d[j][0] = 0


        for i in range(1,len(d)):
            for j in range(1,len(d[0])):
                if coins[i-1] > j:
                    d[i][j] = d[i-1][j]
                else:
                    d[i][j] = min(d[i][j-coins[i-1]]+1,d[i-1][j])

        if d[len(coins)][amount] == 999999:
            return -1
        else:
            return d[len(coins)][amount]
