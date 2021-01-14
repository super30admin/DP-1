# accepted in leetcode
# time - O(n*m)
# recurrsive solution using memoization(dynamic programming concept)
# draw a matrix for the options to be selected and go for the coding part.
def coinChange(coins, amount):
    # create a 2d array of len amount+1 and len of coins+1
    dp = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]
    m = len(dp)  # num of rows
    n = len(dp[0])  # num of cols
    for i in range(1, n):  # fill infinity for first row
        dp[0][i] = float('inf')
    # print(dp)
    for i in range(1, m):
        for j in range(1, n):
            # for each cell in the matrix check if it is less than coin amount, if yes then copy the above cell amount to below else compare with above cell data and (data in cell (current row - coin amount)+1) whichever is minimum as we are looking for minimum number of coins.
            if j < coins[i - 1]:
                dp[i][j] = dp[i - 1][j]
            else:
                dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1)

    # edge case, replace inf with -1
    if dp[m - 1][n - 1] == float('inf'):
        return -1
    # return the count in last cell.
    return dp[m - 1][n - 1]

print(coinChange([1,2,5], 11))