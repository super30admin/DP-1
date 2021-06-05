#exhaustive apporoach
# class Solution:
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         if len(coins)==0:
#             return 0
#         return self.helper(coins,amount,0,0)
#
#
#     def helper(self,coins,amount,index,min_coins):
#         #base
#         if amount==0:
#             return min_coins
#         if (index==len(coins) or amount<0):
#             return -1
#         #choose the coin
#         case1=self.helper(coins,amount-coins[index],index,min_coins+1)
#         #don't choose the coin
#         case2=self.helper(coins,amount,index+1,min_coins)
#         #valid path
#         if case1==-1:
#             return case2
#         if case2==-1:
#             return case1
# 
#         return min(case1,case2)

#DP Apporoach

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins)==0:
            return 0

        dp=[[amount+1]*(amount+1)]*(len(coins)+1) #initiliaze array to, amount+1

        for i in range(len(dp)):
            dp[i][0]=0 #1st column zero
        #print(dp)
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j-coins[i-1] < 0: #going back denomination times if makes it negative, may get index out of range error, to avoid that
                    dp[i][j]=(dp[i-1][j])
                else:
                    dp[i][j]=min(dp[i-1][j], dp[i][j-coins[i-1]]+1) #1 case from above, go back coin denomination times +1

        if dp[len(dp)-1][len(dp[0])-1] ==amount+1: #if amount+1, returning infinity, so return -1
            return -1
        return dp[len(dp)-1][len(dp[0])-1]
