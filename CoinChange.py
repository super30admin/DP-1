from pip import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if(len(coins)==0):
            return -1
        m = len(coins)
        n = amount
        list1 = [0] * (m+1)
        for i in range(len(list1)):
            list1[i] = [0] * (n+1)
        for j in range(1,n+1):
            list1[0][j] = amount + 1
        for i in range(1,m+1):
            for j in range(1,n+1):
                if(j < coins[i-1]):
                    list1[i][j] = list1[i-1][j]
                else:
                    list1[i][j] = min(list1[i-1][j], 1+list1[i][j-coins[i-1]])
        if(list1[m][n] == amount+1):
            return -1
        else:
            return list1[m][n]
                    
        
        