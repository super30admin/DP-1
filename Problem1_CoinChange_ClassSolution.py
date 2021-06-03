'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 322. Coin Change
# You are given an integer array coins representing coins of 
# different denominations and an integer amount representing a total amount 
# of money.

# Return the fewest number of coins that you need to make up that amount. 
# If that amount of money cannot be made up by any combination of the coins, 
# return -1.

# Example 1:

# Input: coins = [1,2,5], amount = 11
# Output: 3
# Explanation: 11 = 5 + 5 + 1
# Example 2:

# Input: coins = [2], amount = 3
# Output: -1
# Example 3:

# Input: coins = [1], amount = 0
# Output: 0
# Example 4:

# Input: coins = [1], amount = 1
# Output: 1
# Example 5:

# Input: coins = [1], amount = 2
# Output: 2

#-----------------
# Time Complexity: 
#-----------------
# O(A*N): Where A is the amount and N is the number of denominations in the 
#         "coins" list. We need a nested for loop to iterate over each
#         denomination (N) and we repeat this for all values of amount 
#         between 1 to amount -> A * N
#------------------
# Space Complexity: 
#------------------
# O(A*N) - We need an array to store the amount -> minimum coins mapping

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  3132 ms (5.01 %ile)
# Space            :  19 MB   (16.95 %ile)
from typing import List
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0 or amount == 0:
            return 0

        # amount+1 filled inside every entry as initialization
        # because maximum amount+1 coins with $1 coins

        dp = [[amount+1 for i in range(amount+1)] for x in range(len(coins)+1)]

        # print(dp)
        # print(f"dp[{len(dp)}][{len(dp[0])}]")
        for i in range(len(dp)):
            dp[i][0] = 0

        for j in range(len(dp[0])):
            dp[0][j] = amount + 1

        for i in range(1, len(dp)):
            # i- iterates over each coin
            for j in range(1, len(dp[0])):
                #j - iterates over each possible value of amount
                # print(f"i:{i}, j:{j}")
                
                if j < coins[i-1]:
                    #Zero case: Because the amount is lesser than 
                    # current coin.
                    # NOTE: Index of current coin will be i-1 in coins
                    # array because we have added an offset row with 
                    # Infinity as each entry
                    dp[i][j] = dp[i-1][j]
                else:
                    zero_case = dp[i-1][j]

                    # Add plus 1 to entry in the same row and  
                    # for current amount - coin_denomination solution
                    # Because we are adding this coin to the count
                    one_case = dp[i][j-coins[i-1]] + 1
                    dp[i][j] = min(zero_case, one_case)

        result = dp[len(dp)-1][len(dp[0])-1]
        if result > amount:
            return -1
        else:
            return result
 

obj = Solution()
print(obj.coinChange([1,2,5], 11))
print(obj.coinChange([1,2,5], 13))
