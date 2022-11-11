#time complexity: O(m*n)
#sapce complexity: O(m*n)
#ran on leetcode: Yes
##Bottom up dp approach. Incrementally calculate the number of denmomination combination
#that can make the amount. Amount ranges from 0 till amount. Store the intermedialte result
#in a 2d array and use it to calculate solution to bigger problems. Either an already
#existing combination is the minimum answer(previous row, same column) or the current coin is part of
#the minimum solution(same row, amount-coin column)
class Solution:
    def coinChange(self, coins, amount: int) -> int:
        dp=[]
        for i in range(len(coins)+1):
            temp=[]
            for j in range(amount+1):
                temp.append(-1)
            dp.append(temp)
        
        for i in range(1,len(dp[0])):
            dp[0][i]=amount+1
        for j in range(0,len(dp)):
            dp[j][0]=0
        #print(dp)
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                #i is the amount
                #j is the coin denomimation
                if(j-coins[i-1]<0):
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j],dp[i][j-coins[i-1]]+1)
        
        #print(dp)
        if(dp[-1][-1]>=amount+1):
            return -1
        #print(dp)
        return dp[-1][-1]
s=Solution()
coins = [1,2,5]
amount = 11
print(s.coinChange(coins,amount))