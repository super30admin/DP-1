# Problem1 (https://leetcode.com/problems/coin-change/)

# BRUTE FROCE APPROACH 
# The recursive approach is the brute force approach

# TC : O(2 ^ (m+n)) 
# n is the number of different coin denominations
# m is the target amount

# SC : O(n+m) for the recursion stack in the worst case

# Approach:
# For each coin, we have two choices:
#       Don't use the coin and move to the next one
#       Use the coin and stay at the same position (allowing for multiple uses of the same coin)
# The recursion terminates when either:
#       We've reached the target amount (found a valid combination)
#       We've gone over the target amount (invalid combination)
#       We've considered all coins without reaching the target (invalid combination)

# On leetcode it shows that time limit is exceeded when submitted

def coinChange(self, coins: list[int], amount: int) -> int:
    result = self.helper(coins, 0, amount, 0)
    if result == float('inf'):
        return -1
    return result
    
def helper(self, coins: list[int], i: int, amount: int, coins_used: int) -> int:
    # Base case
    if amount < 0 or i == len(coins):
        return float('inf')
    
    if amount == 0:
        return coins_used
    
    # Don't choose current coin
    case0 = self.helper(coins, i + 1, amount, coins_used)
    
    # Choose current coin
    case1 = self.helper(coins, i, amount - coins[i], coins_used + 1)
    
    # Return minimum of the two cases
    return min(case0, case1)

# ________________________________________________________________________________________________________________

# THEN GEEDY APPROACH
# start with  the coins of max value
# but this will NOT always work

# ________________________________________________________________________________________________________________

# THEN TABULATION
# this reduces the time complexity to O(n x m)

# TC : O(n × m):
# n = amount
# m = number of coins
# The outer loop iterates through each coin denomination (m iterations)
# For each coin, the inner loop iterates from the coin value to the target amount (at most n iterations per coin)
# Overall complexity is O(n × m)

# SC : O(n) a single 1D array used of size (amount + 1)

# Approach: Bottom-Up Dynamic Programming
# This solution uses a tabulation (bottom-up) dynamic programming approach:
# State Definition: dp[i] represents the minimum number of coins needed to make amount i
# Base Case: dp[0] = 0 (making amount 0 requires 0 coins)
# State Transition: For each coin and each achievable amount:
#       dp[i] = min(dp[i], dp[i - coin] + 1)
#       This means: either keep the current solution for amount i, or use the current coin plus the solution for (i - coin)
# Optimizations:
#       Processing by coin first improves cache locality
#       Sorting coins potentially allows for early termination in some cases
#       The range starts from the coin value to avoid unnecessary comparisons
#       Using infinity as the initial value makes the algorithm more readable

# On leetcode could submit this code


def coinChange(self, coins, amount):
        
    # If amount is 0, we need 0 coins
    if amount == 0:
        return 0
    
    # Initialize dp array with amount+1 (which is greater than any possible solution)
    dp = [amount + 1] * (amount + 1)
    dp[0] = 0  # Base case: 0 coins needed to make amount 0
    
    # For each amount, try each coin
    for i in range(1, amount + 1):
        for coin in coins:
            if coin <= i:  # Can only use coin if it's not larger than current amount
                # Either don't use this coin (dp[i]) or use it (1 + dp[i - coin])
                dp[i] = min(dp[i], 1 + dp[i - coin])
    
    # If dp[amount] is still amount+1, it means no solution
    return dp[amount] if dp[amount] <= amount else -1

