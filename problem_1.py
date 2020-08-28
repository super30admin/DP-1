# Runtime O(n)
# space O(n)

def coinChange(coins, amount):
    
    # in this approach we maintain
    # a dp array of size amount+1
    # we iterate over the range of the
    # amount, we subtract the available
    # denominations and try to find the
    # lowest number of coins used 
    # for a particular denomination 
    # subtraction.  Then we choose 
    # the lowest number of coins

    if amount == 0:
        return 0
    dp = [0]*(amount+1)
    for coin in range(1,amount+1):
        minn = float('inf')
        for change in coins:
            diff = coin - change
            if diff == 0:
                dp[coin] = 1
                break
                
            if diff > 0 and dp[diff]>0:
                minn = min(minn, dp[diff])
                dp[coin] = minn + 1
        
    print(dp)
    if dp[-1] > 0:
        return dp[-1]
    return -1