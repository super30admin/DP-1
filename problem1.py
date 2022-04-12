#coin change


# // Time Complexity : O(N*M) N= length of coins M= amount
# // Space Complexity :O(N*M)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



def coinChange( coins, amount):
    if amount ==0:
        return 0
    
    dp=[[amount +1 for i in range(amount+1)] for j in range(len(coins)+1)]
    
    for i in range(len(dp)):
        for j in range(len(dp[0])):
            if(j==0):
                dp[i][j] = 0
            elif (j<coins[i-1]):                                #if the coin is bigger than the total amount, just take the value of the previous coin
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j]=min(dp[i-1][j], 1 + dp[i][j-coins[i-1]])   #take the max between the last coin or 1+last time you used that coin
                
    if dp[len(coins)][amount] == amount+1:
        return -1
    return dp[len(coins)][amount]