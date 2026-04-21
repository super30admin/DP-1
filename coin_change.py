# Time Complexity : O(m * n) n:number of coins, m: amount
# Space complexity :O(m) m: amount
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : converting recurrsive  solution to dp soltion was hard.

# Your code here along with comments explaining your approach
# create an array (dp) where every index represents a target amount and fill it with  amount + 1 that represents infinity.
# Loop through every amount from 1 to target,checking each coin to see if using that will result in fewer coins than the current best.
# Once the array is fully populated look at the very last index (dp[amount]); if it’s still "infinity," the amount is impossible to make else that index is the answer.
def coinChange(coins, amount):
    """
    :type coins: List[int]
    :type amount: int
    :rtype: int
    """ 

    dp = [amount + 1] * (amount + 1)
    dp[0] = 0
    for a in range(1,amount + 1):
        for c in coins:
            if a - c >= 0:
                dp[a] = min(dp[a], 1+dp[a-c])
    return dp[amount] if dp[amount] != amount + 1 else -1