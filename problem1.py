class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # memo={}
        # def helper(index,total):
        #     if (index,total) in memo:
        #         return memo[(index,total)]
        #     if total==amount:
        #         return 0
        #     if index>=len(coins) or total>amount:
        #         return float('inf')
            
        #     take = 1+ helper(index,total+coins[index])
        #     skip = helper(index+1, total)
        #     memo[(index,total)] = min(take,skip)
        #     return memo[(index,total)]
     
        # result = helper(0,0)
        # return result if result!=float('inf') else -1

        
        # Inititlie the dp array with 0's with one extra row and one extra column
        dp = [[0]*(amount+1) for i in range(len(coins)+1)]

        # Initialize the first row with max value as we can not make up those amount with 0 coin
        for i in range(1,amount+1):
            dp[0][i]=float('inf')

        # Starting iteration for the 1st coin
        for c in range(1,len(coins)+1):
            for amt in range(1,amount+1):
                # If we can make that amount with the given coin
                if amt-coins[c-1]>=0:
                    # It has to be the minimum of not chosing that coin which is present above
                    # and chosing the coin, if we chose that see the value in the sub problem with the amount-coin
                    dp[c][amt] = min(dp[c-1][amt],1+dp[c][amt-coins[c-1]])
                else:
                    #chose the row above
                    dp[c][amt]=dp[c-1][amt]
        # Check the last row and column of our dp table as this is where we have all the coins available and the amount
        if dp[len(coins)][amount]!=float('inf'):
             return dp[len(coins)][amount]
        else:
             return -1
        