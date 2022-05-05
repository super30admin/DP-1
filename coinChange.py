#TimeComplexity: coins:M , amount:N then M*O(N)
#SpaceComplexity: O(N) for every amount we will store min coins needed
#It successfully runs on leetcode

def coinChange(coins, amount):

    #initialize 0 at 0 index as for amount 0 we will need 0 coins
    #initialize min coin needed for every amount to infinity to store max value, so that we can use it to find min

    dp=[0]+[float("inf") for _ in range(amount)]

    for amt in range(1, amount+1): #amount+1 will store min coins needed for question
        for coin in coins: #for every amount we will surf all coins and try to find min coin needed
            if amt-coin >= 0: #if coin is less than amount
                dp[amt]= min(dp[amt],dp[amt-coin] + 1) #if we use coin then increament the count 
    #if we cant make the amount from available coins then initial infinity will neva change and will return -1
    return dp[amount] if dp[amount]!=float("inf") else -1

print(coinChange([1,2,3],5))