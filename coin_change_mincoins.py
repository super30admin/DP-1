import sys
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        lis=[[0 for i in range(0,(amount)+1)] for j in range(0,len(coins)+1)]
        lis[0][0]=0
        for i in range(1,amount+1):
            lis[0][i]=sys.maxsize
        lis[1][0]=0
        
        # for i in range(1,amount+1):
        #     lis[1][i]=i
        for i in range(1,len(coins)+1):
            for j in range(0,amount+1):
                if j<coins[i-1]:
                    lis[i][j]=lis[i-1][j]
                else:
                    lis[i][j]=min(lis[i-1][j],1+lis[i][j-coins[i-1]])
        
        min1=999999999
        for i in range(1,len(coins)+1):
            if min1>lis[i][amount]:
                min1=lis[i][amount]


        # print(lis)

        if min1==999999999:
            return -1

        return min1