"""
Status - Try exhaustive recursion approach
Leetcode - https://leetcode.com/problems/coin-change/
TC- O(amount*C), SC- O(amount*C)
Lecture- https://youtu.be/XwkN-LhZ6Xk
FAQ-
What should be your approach?
Think greedy, then exhaustive if doesn't work, then DP.

You are given an integer array coins representing coins of different denominations and an integer amount representing
a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
 combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
"""

'''
Idea - Dynamic programming-
At each point we have two choices to pick a denomination, either you choose that or you don't.
This will lead to a exhaustive solution but pay attention, you will have duplicate exhaustion, so we start bottom up DP
and try to see if we can come up with a generalization to calculate out target which is, number of coins, in this case. 

        [1,2,5], 11
        0 /     \ 1 -- 0 is not choosing coin 1, 1 is choosing coin 1
        [2,5], 11   [1,2,5], 10  - minimum number of coins = min([2,5], [1,2,5]) 

        0           1           2               3               4               5               6               7               8               9               10              11
        
0       0          inf         inf             inf             inf             inf             inf             inf             inf             inf              inf            inf

1       0           1           2               3               4               5               6               7               8               9               10              11

2               min(1,-)     min(2,0+1)    min(3,1+1)        min(4,1+1)     min(5,2+1)      min(6,2+1)      min(7,3+1)      min(8,3+1)      min(9,4+1)      min(10,4+1)      min(11,5+1)
        =0          1           1               2               2               3               3               4               4               5               5                6
        
5               min(1,-)     min(2,-)      min(2,-)          min(2,-)        min(3,0+1)      min(3,1+1)      min(4,1+1)      min(4,2+1)      min(5,2+1)      min(10,1+1)      min(6,2+1)
        =0          1           1               2               2               1               2               2               3               3               2                3  

DP[i][j] can be generalized as min(DP[i-1][j], DP[i][j-coinValue[i]]). 
Initial values - DP[0][0] = 0. Also deal with corner cases, DP[i][j-coinValue < 0]

'''


class Solution:
    def coinChange(self, coins, amount):
        # prepare initial table
        m, n = len(coins) + 1, amount + 1
        dp = [[2 ** 31] * n for _ in range(m)]
        dp[0][0] = 0
        # fill the table values based on the generalization rules
        for i in range(1, m):
            for j in range(0, n):
                denomination = coins[i - 1]
                if j - denomination < 0:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - denomination] + 1)

        # combination not found
        if dp[m - 1][n - 1] == 2 ** 31:
            return -1
        return dp[m - 1][n - 1]


coins = [1, 2, 5]
amount = 11
minCoins = Solution().coinChange(coins, amount)
print(minCoins)
