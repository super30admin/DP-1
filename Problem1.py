# Problem1 (https://leetcode.com/problems/coin-change/)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0 or not coins:
            return 0
        
        m = amount
        n = len(coins)
        dpMatrix = [[0 * i for i in range(m+1)] for j in range(n+1)]
        for x in range(n+1):
            for y in range(m+1):
                if x==0:
                    if y==0:
                        dpMatrix[x][y] = 0
                    else:
                        dpMatrix[x][y] = sys.maxsize
                else:
                    if(coins[x-1]>y):
                        case1 = dpMatrix[x-1][y]
                    else:
                        case1 = 1 + dpMatrix[x][y-coins[x-1]]
                    case0 = dpMatrix[x-1][y]
                    dpMatrix[x][y] = min(case0,case1)
        
        return(-1 if dpMatrix[n][m] == sys.maxsize else dpMatrix[n][m])