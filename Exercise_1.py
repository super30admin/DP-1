# Time Complexity: O(n*m)
# Space Complexity: O(n*m)
# Were you able to run the code on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        dp = [[0 for j in range(amount+1)] for i in range(len(coins)+1) ] 

        for j in range(1, len(dp[0]) ):
            # Initialize the first row with amount+1, as no combination can form that amount with 0 coins
            dp[0][j] = amount+1


        for i in range(1,len(dp)):

            for j in range(1, len(dp[0])):  
                # If the coin value is greater than the amount, we cannot use it, so we take the previous row's value
                if (j - coins[i-1]) < 0:
                    dp[i][j] = dp[i-1][j]
                    
                # If the coin value is less than or equal to the amount, we use the minimum of two cases:
                # 1. Not using the coin (previous row's value)
                # 2. Using the coin (current row's value at j - coin value + 1)
                else:
                    dp[i][j] = min(dp[i-1][j] , dp[i][ j - coins[i-1] ] + 1 )

        # print(dp)
        return -1 if dp[len(coins)][amount] > amount else dp[len(coins)][amount]
                    