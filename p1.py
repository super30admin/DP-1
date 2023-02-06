#TC = o(m*n)
#SC = O(m*n)
#successfully submitted on leetcode: yes


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        #if amount == 0:
            #return 0
        
        #create 2D array
        #cols(12 cols) are amount 0,1,2,...11
        #rows(4 rows) are coins: 0, 1, 2, 5
        rows, cols = (len(coins) + 1, amount + 1)
        arr = [[0 for i in range(cols)] for j in range(rows)]

        #update row[0] values to amount + 1
        for j in range(1, len(arr[0])):
            arr[0][j] = amount + 1
        
        #handle the rest of the rows
        for i in range(1, len(arr)):
            for j in range(1, len(arr[0])):
                if j < coins[i - 1]:
                    arr[i][j] = arr[i - 1][j]
                else:
                    arr[i][j] = min(arr[i-1][j], 1 + arr[i][j-coins[i - 1]])
        ans = arr[rows-1][cols-1]
        if ans > amount:
            return -1
        return ans