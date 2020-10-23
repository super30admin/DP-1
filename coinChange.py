# As taught in class, the  solution here will be to design a grid and memoise the result to get solution
# Time Complexity: O(n^2)
# Space Complexity: O(sizee of matrix)
def coinChange(coins,amount):
    if (coins is None or len(coins) is 0):
        return 0
    dp = [0 for x in range(amount+1) for y in range(len(coins)+1)] 
    for i in range(1,len(dp)):
        dp[0][i] = 9999
    for i in range(len(coins)+1):
        for j in range(amount+1):
            if(j < coins[i-1]):
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = min(dp[i-1][j],1+dp[i][j-coins[i-1]])
    res =  dp[len(dp)-1][len(dp[0])-1]
    if res > 9999:
        return -1
    return dp[len(dp)-1][len(dp[0])-1]

    
coins = [1,2,5]
amount = 13
ans = coinChange(coins,amount)
print(ans)