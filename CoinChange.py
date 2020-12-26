#Time Complexity: O(m*n)
#Space Complexity: O(m*n)
def coinChange(self, coins: List[int], amount: int) -> int:
    rows = len(coins)+1
    cols = amount+1
    dp = [ [None for i in range(cols)] for j in range(rows)]
    
    for i in range(rows):
        dp[i][0] = 0
    
    for j in range(1, cols):
        dp[0][j] = 99999
    
    for ci in range(1,rows):
        for amt in range(1,cols):
            if amt < coins[ci-1]:
                dp[ci][amt] = dp[ci-1][amt]
            else:
                upper = dp[ci-1][amt]
                left = dp[ci][amt-coins[ci-1]] + 1
                minimum = min(upper,left)
                dp[ci][amt] = minimum
    if (dp[rows-1][amount]) == 99999:
        return -1
    else:
        return dp[rows-1][amount]
            