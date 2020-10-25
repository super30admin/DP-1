def coinChange(self, coins, amount):
    dp=[[None for i in range(amount+1)] for i in range(len(coins)+1)]
    if amount==0:
        return 0
    for j in range(1,len(dp[0])):
        dp[0][j]=9999
    for i in range(1,len(dp)):
        for j in range(1,len(dp[0])):
            if j<coins[i-1]:
                dp[i][j]=dp[i-1][j]
            elif j==coins[i-1]:
                dp[i][j]=1
            else:
                dp[i][j]=min(dp[i-1][j], 1 + dp[i][j-coins[i-1]])
                # print(dp[i][j])
    if dp[len(dp)-1][len(dp[0])-1]>=9999:
        return -1
    return dp[len(dp)-1][len(dp[0])-1]

#time= O(nm) n is length of coins and m is amount
# space = O(nm)

# Recursion
#         if coins==[] or amount==0:
#             return 0
#         def helper(coins,index,amount,minn):
#             if amount==0:
#                 return minn
#             if amount<0 or index>=len(coins):
#                 return -1

#         # choose
#             case1=helper(coins,index,amount-coins[index],minn+1)
#             # print(case1)
#         # not choose
#             case2=helper(coins,index+1,amount,minn)
#             if case1==-1:
#                 return case2
#             if case2==-1:
#                 return case1
#             return min(case1,case2)
#         return helper(coins,0,amount,0)