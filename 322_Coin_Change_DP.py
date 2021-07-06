# Time Complexity : O(k * n) [k = amount, n = number of coins in the input list, ]
# 
# Space Complexity : O(k) [k = amount]
# 
# Did this code successfully run on Leetcode : Yes
# 
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# 1. Create memo list of size (amount+1). At each index, it holds the minimum number of coins required to reach the amount(index) 
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:return 0
        
        memo = [0 for i in range(amount+1)]
        
        for i in range(1, amount+1):
            min_coin_count = float(inf)
            for coin in coins:
                if coin <= i:# True, if the coin value is greater than current amount(i)
                    # Add 1 to denote the current coin added
                    # Subtract the value of current coin from index and add the value(minimum at that index) found in memo at the resultant index
                    min_coin_count = min(min_coin_count, 1 + memo[i-coin])
            memo[i] = min_coin_count
        
        # True, if none of the coin value was less than the amount
        if min_coin_count == float(inf):
            return -1
                
        return memo[amount]