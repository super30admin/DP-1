#Time Complexity: O(m*n)
#Space Complexity: O(m*n)
#Problem sucessfully accepted in leetcode: yes
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n=len(coins)
        dp=[[0for i in range(amount+1)]for j in range(n+1)]
#Initialize first column to 0
        for i in range(n+1):
            dp[i][0]=0
#Initialize first row to max possible i.e amount
        for j in range(1,amount+1):
            dp[0][j]=amount+1
        for i in range(1,n+1):
            for j in range(1,amount+1):
#If current column is less than denomination, it cannot contribute to sum
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
#Add the max of taking and not taking current coin to the dp matrix
                    dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i-1]])
#Return -1 if sum cannot be formed with given coins
#Else, return the minimum coins that give the sum amount
        return -1 if dp[n][amount]==amount+1 else dp[n][amount]