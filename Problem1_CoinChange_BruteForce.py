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
# O(S^N): S is amount and N is number of coins.
#        
#------------------
# Space Complexity: 
#------------------
# O(N) - Max depth of recursion

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  32 ms (59.16 %ile)
# Space            :  14.1 MB (92.00 %ile)

import sys
INT_MAX_VALUE = sys.maxsize
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        return self.coinChangeRecursive(coins, amount)

    def coinChangeRecursive(self, coins: List[int], remainder: int) -> int:
        # If remainder goes negative, that means there were no coins to match
        # the exact amount, we have to overpay
        if remainder < 0:
            return -1
        
        # If remainder or amount becomes 0, we don't need any coins to fulfill
        elif remainder == 0:
            return 0
        
        else:
            # Setting min_coins variable to max to allow for min() calculation
            min_coins = INT_MAX_VALUE
            
            #For every denomination of coins, we recursively calculate the
            # the minimum number of coins required to fill the remainder amount
            for denomination in coins:
                count = self.coinChangeRecursive(coins, \
                    remainder-denomination)
                
                if count == -1: 
                    continue
                
                else:
                    # Count + 1 because we are adding 1 coin of some
                    # denomination at every step
                    min_coins = min(min_coins, count + 1)

            if min_coins == INT_MAX_VALUE:
                return -1
            else:
                return min_coins




