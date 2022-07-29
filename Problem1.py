# Time complexity : O(n*m) - n = number of coins and m = amount
# Space complexity : O(n*m) -  n = number of coins and m = amount
# Leetcode : Solved and submitted

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        # check if the coins are 0, then we return 0 as we can't do anything
        if len(coins) == 0:
            return 0

        # find the length and width of the matrix and then creating an empty array
        m = len(coins)
        n = amount
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        #print(dp)
        # top row
        # For the top row, for index (0,0), we put the value 0, and on the first row, we put the max value possible as we are looking for minimum coins
        # So the max value would be amount + 1, as for inf, if we add value to it, then it can overflow and give a garbage value
        for j in range(1,len(dp[0])):
              dp[0][j] = amount + 1

        # Then we traverse over the matrix and update the values based on the previously stored values
        for i in range(1,len(dp)):
              for j in range(1,len(dp[0])):
                    # if the amount is less than the value of the coin, then we copy the value from upper row as we use the same coins
                    if j < coins[i-1]:
                        dp[i][j] = dp[i-1][j]
                    else:
                    # If we can make a change of couns, then take the min out of the previous operation or get another one by
                    # using the new coin and making a change in quantity of coins
                        dp[i][j] = min(dp[i-1][j],1+dp[i][j - coins[i-1]])
        # result will always be stored at the last position as it has considered all the available coins
        res = dp[m][n]

        # if we get the final amount greater than the one we initially had, that means, we couldn't find the change from the coins available otherwise
        # return the value present at the last index in the matrix
        if res > amount:
              return -1
        return res
