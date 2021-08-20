# Coin Change

# Time Complexity : O(N * C), where N: amount 
# Space Complexity : O(N), where N: amount
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
def coinChange(self, coins: List[int], amount: int) -> int:

    # If there are no coins, we can't make that amount
    if not coins: return -1
    coins = set(coins)

    # `memo` array keeps track of the min number of coins that make up the index amount
    memo = [float('inf') for _ in range(amount+1)]
    memo[0] = 0
    
    for amt in range(len(memo)): 

        # We add one coin at a time and check if we find a lower number of coins that make up that amount
        for c in coins:
            if amt - c >= 0:
                memo[amt] = min(memo[amt], memo[amt-c]+1)
    return memo[amount] if memo[amount] != float('inf') else -1