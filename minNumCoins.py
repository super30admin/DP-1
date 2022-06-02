 # Time Complexity : O(numCoins * Amount) 
 # Space Complexity: O(numCoins * Amount) 
def coinChange(coins, amount):
        maxcoins=99999
        rows=[None]*(len(coins)+1)
        for i in range(len(rows)):
            rows[i]=[None]*(amount+1)
        dptable=rows
        for i in range(len(coins)+1):
            dptable[i][0]=0
        for j in range(amount+1):
            dptable[0][j]=maxcoins
        for coin in range(1,len(coins)+1):
            for amt in range(1,amount+1):
                if amt<coins[coin-1]:
                    dptable[coin][amt]=dptable[coin-1][amt]
                else:
                    dptable[coin][amt]=min(dptable[coin-1][amt], 1+dptable[coin][amt-coins[coin-1]])
        mincoins=dptable[len(coins)][amount]
        if mincoins<maxcoins:
            return mincoins
        else:
            return -1
            
res=coinChange([1,2,5], 11)
print(res)