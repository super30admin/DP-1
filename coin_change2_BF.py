# This is a Brute force solution. The time complexity is exponential.
# This will work on a few cases and fail on some where we will reach the max
# recursion depth

def coinchange(coins, amount):
    if not coins:return 0
    return helper(coins, amount, idx=0)

def helper(coins, amount, idx):
    # Base Case
    if amount == 0: return 1
    if amount < 0 or idx == len(coins): return 0

    pick = helper(coins, amount-coins[idx], idx)
    skip = helper(coins,amount, idx+1)
    return skip + pick


