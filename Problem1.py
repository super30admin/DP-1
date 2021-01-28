# Time Complexity :O(n^m) where n is number of coins and m is amount
# Space Complexity :O(n^m)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode : 322

# You are given coins of different denominations and a total amount of money amount.
# Write a function to compute the fewest number of coins that you need to make up that amount.
# If that amount of money cannot be made up by any combination of the coins, return -1
# You may assume that you have an infinite number of each kind of coin.

# Example 1:
#
# Input: coins = [1,2,5], amount = 11
# Output: 3
# Explanation: 11 = 5 + 5 + 1
# Example 2:
#
# Input: coins = [2], amount = 3
# Output: -1

def main():
    coins = [1,2,5]
    amount = 11
    ans = coinChange(coins,amount)
    print(ans)

def coinChange(coins, amount):
    """
    :type coins: List[int]
    :type amount: int
    :rtype: int
    """

    # Make a matrix where rows are all the coins plus one dummy 0 and coulums is amount plus one dummy 0
    n = len(coins) + 1
    m = amount + 1

    # Initialize with 0
    dp = [[0 for col in range(m)] for row in range(n)]

    # Initialize first row with infinity because you cannot make any amount with 0 coins or set it to the amount itself + 1 to avoid infinity
    for index in range(1, m):
        dp[0][index] = amount + 1

    # Iterating over matrix
    for i in range(1, n):
        for j in range(1, m):
            # First condition where the amount itself is lower than the coin then use the previous coins which on top of it.
            if j < coins[i - 1]:
                dp[i][j] = dp[i - 1][j]

            # If that is not the case, then it is either choose or dont choose. If we dont choose, then we take the above value
            # If we choose, then we subtract the current coin value from the amount and take that particular value from the table. For eg if we have to make 2 from [1,2] then we subtract 2 from 2 which is 0 and then we will add 1 to it as we used 2 and find the value in [1,2] 0. Hence it is coins[i][j-coins[i-1]]

            else:
                dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1)

    # We have to return -1 if we cannot make that amount. Hence the base case is altered here.
    return -1 if dp[-1][-1] > amount else dp[-1][-1]


if __name__ == '__main__':
    main()