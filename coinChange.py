 """
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Input: coins = [2], amount = 3
Output: -1
Input: coins = [1], amount = 0
Output: 0
Input: coins = [1], amount = 1
Output: 1
Input: coins = [1], amount = 2
Output: 2

Brute Force:
    at every step either choose the element or not,
    
    if you have choosen an element  from the coin, reduce the total amount by coins[index] and increase the number of coins by one

    if you are not choosing the element at index, increase the index by on and keep the amount and number of coins as same

    time complexity  -  exponential (as there are repeated operations)

    def coinChange(coins, amount) -> int:
        if(coins == None or len(coins) == 0):
            return -1
        return helper(coins, amount, index=0, minimumCoins = 0)
    
    def helper(coins, amount, index, minimumCoins):
        #base case
        if(amount == 0):
            return minimumCoins
        if(amount < 0 || index == len(coins)):
            return -1

        #logic
        case1 = helper(coins, amount-coins[index],index minimumCoins+1)
        case2 = helper(coins, amount, index+1, minimumCoins)

        if(case1 == -1):
            return case2
        if(case2 == -1):
            return case1
        
        return min(case1, case2)
 """
 
""" 
 using Dynamic programming to reduce the exponential solution to 
 build a 2D matrix
 columns would be amount needed
 rows would be denominations

            0  if i=0
            math.inf if j=0
 d[i][j] =  d[i-1][j] if coins[i-1] > j
            else min(d[i-1][j], d[i][j-coins[i-1]]+1)
 
"""
def coinChange(coins, amount) -> int:
    dp = []
    dp.append([0] + [amount+1]*amount)
    for i in range(1, len(coins)+1):
        dp.append([0])
        for j in range(1, amount+1):
            if(coins[i-1] > j):
                dp[i].append(dp[i-1][j])
            else:
                dp[i].append(min(dp[i-1][j], dp[i][j-coins[i-1]]+1))
    if(dp[-1][-1] ==amount+1):
        return -1
    else:
        return dp[-1][-1]