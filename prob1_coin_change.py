class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        """
        Time Complexity: O(m x n)
        Space Complexity: O(m x n)
        Did this code successfully run on Leetcode: Yes 

        Any problem you faced while coding this: No
        Your code here along with comments explaining your approach:
        The approach: 
            - Create an array of arrays 
            - First row should have [0, inf(1), inf(2), .... inf(amount)]
            - Run nested for loops 
                - Check if the index is less then the denomination of interest (i.e. j)
                - If yes then the value at i, j index = value at i-1, j index
                - If not then value = mininum of the value at i-1,jth index and value at dp[i][j - denomination] + 1
            - if the final value (i.e. dp[len(coins)][amount]) == inf:
                return - 1
            - else return dp[len(coins)][amount]) == inf
        """

        dp = list()
        dp.append(list())
        dp[0].append(0)

        inf = float('inf')
        for i in range(1, amount + 1):
            dp[0].append(inf)

            
        for i in range(1,len(coins) + 1):
            dp.append([0]* (amount + 1))
            for j in range(1, amount +1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min([
                        1 + dp[i][j-coins[i-1]], 
                        dp[i-1][j]]
                        )
        if dp[len(coins)][amount] == inf:
            return -1
        return dp[len(coins)][amount]
