'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 198. House Robber
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
# O(A) - We need an array to store the amount -> minimum coins mapping

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  1436 ms (55.47 %ile)
# Space            :  14.4 MB (80.92 %ile)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # We use this MAX_VALUE to store a large unreasonable number of coins
        # to make an amount. The logic is, if lowest value of a coin = 1
        # Then we need atmost "amount" number of $1 coins to make $amount
        MAX_VALUE = amount + 1

        # The minimum number of coins required to make amount "i"
        # is stored in amount_mincoins_map[i]
        # We need amount + 1 copies because we are also calculating 
        # number of coins to make amount = 0
        amount_mincoins_map = [MAX_VALUE] * (amount + 1)

        #Base case: Amount = 0, number of coins required to make amount = 0
        amount_mincoins_map[0] = 0

        # We already know amount_mincoins_map[0] = 0 so we start from index 1
        # Consider every amount between 1 and the desired amount
        for i in range(1, len(amount_mincoins_map)):
            for coin in coins:
                if i - coin < 0:
                    # If a coin is bigger than the amount being considered
                    # Do nothing, take next coin
                    continue
                else:
                    # Update the mincoins count for amount "i" with the 
                    # minimum between current mincoins count for amount "i" 
                    # and the mincoins count for the (amount-coin) + 1
                    # amount-coin because we are reducing the remainder by
                    # coin and +1 because we are using 1 coin.
                    amount_mincoins_map[i] = min(amount_mincoins_map[i],\
                        amount_mincoins_map[i-coin] + 1)

        if amount_mincoins_map[amount] == MAX_VALUE:
            # We never updated amount_mincoins_map , hence we couldn't fill
            # the amount exactly with the coins given
            return -1
        
        else:
            return amount_mincoins_map[amount]