'''
time complexity: O(N*N)
space complexityL O(N*N)
'''
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        dpArr = [[None for i in range(amount+1)] for j in range(len(coins)+1)]
        
        for i in range(len(coins)+1):
            dpArr[i][0] = 0
            
        for j in range(len(dpArr[0])):
            dpArr[0][j] = 9999
            
        for i in range(1,len(dpArr)):
            for j in range(1,len(dpArr[0])):
                if(j<coins[i-1]):
                    dpArr[i][j] = dpArr[i-1][j]
                else:
                    dpArr[i][j] = min(dpArr[i-1][j],dpArr[i][j-coins[i-1]]+1)
        return dpArr[-1][-1] if dpArr[-1][-1]!=9999 else -1 