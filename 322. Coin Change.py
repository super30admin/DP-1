#TC: O(m*n)
#SC: O(m*n)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)+1
        m = amount +1
        mtx = [[0 for i in range(m)] for j in range(n)]
        for i in range(1,m):
            mtx[0][i] = amount +1
            
        for j in range(0,n):
            mtx[j][0]=0
        for i in range(1,n):
            for j in range(1,m):
                if j<coins[i-1]:
                    mtx[i][j] = mtx[i-1][j]
                else:
                    mtx[i][j]= min(mtx[i-1][j], 1 + mtx[i][j-coins[i-1]])
        return -1 if mtx[n-1][m-1]== amount+1 else mtx[n-1][m-1] 