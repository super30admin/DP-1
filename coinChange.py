class Solution:
    def coinChange(self, coins, amount):
        valueArray=[float('inf') for _ in range(amount+1)]
        valueArray[0]=0
        for amountVal in range(1,amount+1):
            for coin in coins:
                # print('coin,amountVal-coin,amountVal::',coin,amountVal-coin,amountVal)
                if amountVal-coin>=0:
                    valueArray[amountVal]=min(valueArray[amountVal],valueArray[amountVal-coin]+1)
                    # print(dp[amountVal])
        if valueArray[-1]==float('inf'):
            return -1
        else:
            return valueArray[-1]
a=Solution()
print(a.coinChange([1,2,5], 11))