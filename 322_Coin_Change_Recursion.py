# Time Complexity : O(k ^ n) [k = amount, n = number of coins in the input list, ]
# 
# Space Complexity : O(k ^ n) [Total K^n function calls, so it uses stack space]
# 
# Did this code successfully run on Leetcode : Partially(TLE)
# 
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# 1. Make N recusive calls in each step and find which recursive call makes the amount to 0 minimum number of steps
# 2. Steps followed in each recursive call
#   2.1 Decrease the amount by coin value
#   2.2 Increse the coin count
# 3. The solution hit case when amount is reduced to 0 
class Solution:
    def coinChangeUtil(self, coins, amount, coin_count):
        if amount == 0:
            return coin_count
        min_coin_count = float(inf)
        for coin in coins:
            if amount - coin >= 0: # make recursive call only if the coin value is greater than current amount
                min_coin_count = min(min_coin_count, self.coinChangeUtil(coins, amount-coin, coin_count+1))
        # If none of the amaount value cannot be generated with any of the coin value -1 is returned
        return min_coin_count if min_coin_count!= float(inf) else  -1
        
    def coinChange(self, coins: List[int], amount: int) -> int:
         return self.coinChangeUtil(coins, amount, 0)