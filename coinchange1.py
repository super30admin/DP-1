#TC:O(nm)
#SC:O(nm)
#Successfully ran on leetcode

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n=len(coins)+1
        m=amount+1

        ma=0
        table=[[ma]*m for i in range(n)]

        #initialization
        for i in range(n):
            for j in range(m):
                if j==0:
                    table[i][j]=0
                if i==0 and j!=0:
                    table[i][j]=99999

        #DP function
        for i in range(1,n):
            for j in range(1,m):
                if j<coins[i-1]:
                    table[i][j]=table[i-1][j]
                else:
                    table[i][j]=min(1+table[i][j-coins[i-1]],table[i-1][j])

        #answer
        if table[n-1][m-1]!=-99999 and table[n-1][m-1]!=99999:
            return table[n-1][m-1]

        return -1


        
