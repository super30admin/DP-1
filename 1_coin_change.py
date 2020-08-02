class Solution:
    '''
    Time complexity =  O(amount x len(coins))
    space complexity = O(amount x len(coins))

    logic:
    using Dynamic programming matrix.
    if amount is less than curr coin value than curr coin is not useful.
    else min(amount achieved without using curr coin, curr coin + (amount - coin) achieved by curr coin)

      amount:   0   1            2              3                   4
    coins:
    0           0   inf         inf             inf                 inf

    2           0   inf     min(inf,1+0)=1   min(inf,inf)=inf   min(inf,1+1)=2

    3           0   inf         above      min(inf,1+0)=1       min(2,1+inf)=2
    '''
    def coinChange(self, coins, amount) -> int:
        c=amount+1
        r=len(coins)+1
        dpmat=[[9999 for _ in range(c)] for _ in range(r)]
        for i in range(r):
            dpmat[i][0] = 0

        for i in range(1,r): # current coin is coins[i-1]
            for j in range(1,c):
                if j<coins[i-1]:
                    dpmat[i][j]=dpmat[i-1][j]
                else:
                    # i-1 is present coin
                    dpmat[i][j]=min(dpmat[i-1][j],1+dpmat[i][j-coins[i-1]])

        if dpmat[len(coins)][amount] == 9999:
            return -1
        else:
            return dpmat[len(coins)][amount]

coins=[1,2,3,4,5]
amount=10

print(Solution.coinChange(Solution,coins,amount))
