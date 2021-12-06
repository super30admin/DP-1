# // Time Complexity : O(m*n)
# // Space Complexity :O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach


class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int

        Pseudocode:
        initialise 2d array

        write base case

        write logic

        """
        rows = len(coins) + 1
        cols = amount + 1
        arr = [[0]*cols]*rows

        for i in range(1,cols):
            arr[0][i] = amount + 1

        for i in range(1,rows):
            for j in range(1,cols):
                # case where the amount is less than the current coin
                if j < coins[i - 1]:
                    arr[i][j] = arr[i-1][j]

                #else part
                else:
                    current_coin = coins[i - 1]
                    compare1 = arr[i][j-current_coin] + 1
                    compare2 = arr[i-1][j]
                    arr[i][j] = min(compare1,compare2)

        # print(arr)
        if (arr[rows-1][cols-1] > amount):
            return -1


        return arr[rows-1][cols-1]



