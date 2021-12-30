#Time Complexity : O(m*n)
#Space Complexity : O(m*n)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : According to leetcode, my solution was only better than 9 % of solutions.
#I know that this metric isn't the best criteria, but I am wondering where I can optimize my code

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        #edge case
        if coins == []:
            return -1

        rows = len(coins) + 1
        cols = amount + 1

         #initialize dp matrix
        dp = []
        for rowIndex in range(rows):
            currentRow = []
            for colIndex in range(cols):
                if rowIndex == 0 and colIndex >= 1:
                    currentRow.append(9999)
                else:
                    currentRow.append(0)
            dp.append(currentRow)

        for i in range(1,rows):
            for j in range(1,cols):
                #we do i-1 because of the "dummy" row
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    #it'll be the minimum of the value above or amount of denominations to the left + 1
                    dp[i][j] = min(dp[i-1][j], dp[i][j - coins[i -1]] + 1)

        result = dp[rows-1][cols-1]
        if result >= 9999:
            return -1
        else:
            return result