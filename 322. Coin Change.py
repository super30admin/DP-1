#Time Complexity:O(n*m)
#Space Complexity:O(n*m)
#n-Number of coins
#m-Amount
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        change=[[0]*(amount+1)]*(len(coins)+1)
        for i in range(1,amount+1):
            change[0][i]=amount+1
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j <coins[i-1]:
                    change[i][j]=change[i-1][j]
                else:
                    change[i][j]=min(change[i-1][j],change[i][j-coins[i-1]]+1)
        if change[len(coins)][amount]== amount+1:
            return -1
        else:
            return change[len(coins)][amount]