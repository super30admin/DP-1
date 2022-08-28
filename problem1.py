"""
Time Complexity: O(m*n) where m is number of coins and n is the amount 
Space Complexity: O(m*n) where m is number of coins and n is the amount 

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
1. Greedy approach:
Let's take a given test case 
    Coins [1,2,5] and amount = 11 with Greedy approach 
    - First we will choose maximum 5 and will subtract 5 from 11
        11 - 5 = 6
        selectedCoins = [5] amountRemaining = 6
    - Again 6 - 5 > 1, we can again choose 5. 
        selectedCoins = [5,5] amountRemaining = 1
    - Now, the next feasibile coint that can be choose is 1
        selectedCoins = [5,5,1] amountRemaining = 0
    
    However with Greedy, the example [2,5] amount = 6 will not lead to the no soultion.
    With Greedy first we will select 5 but there is no next coin can be selected from the available coins.
    But, we can reach to the possible answer be selecting coins [2,2,2]. So Greedy will not work for every test case

2. Exhaustive Approach:
    - In this approach we will find all the possible answers and will choose the best among them.
    - To find the best possible answer we will form the binary tree on the basis of two things:
        1. Choosing Particular value
        2. Not choosing particular value
    For example [2,5]
                [2,5] amount = 6
    If we draw, the tree we can see there are many calulcations are repeated. And its time complexity is also exponentioal (2^n)
    So to improve the code we will use Dynamic Programming

3. Dynamic Programming
    - Dynamic Programming is an optimization technique which stores the data so that stored data can be use for further reference to avoid same repetative calculations.
    The coin change problem can be solve using dp in following steps:

    1. The deciding factor/constrains for this problem are amount and available number of coins. Hence 2D array will be required to solve this problem
       rows = amount (0 to 11)
       columns = number of coins. In this case 1,2,5. 
       The additional dummy row and coulum of (0,0) will be inserted in the beginning to store the reference values which will be required for first calculation

amount->   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 
Coins
    |  0   | 0 | 12| 12| 12| 12| 12| 12| 12| 12| 12| 12 | 12 |             
    v  1   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 |  
       2   | 0 | 1 | 1 | 2 | 2 | 3 | 3 | 4 | 4 | 5 | 5  | 6  |  
       5   | 0 | 1 | 1 | 1 | 1 | 1 | 2 | 2 | 2 | 2 | 2  | 3  |  

Initially, 0th row is initialized to 12 (amount + 1). 
dp[1][0] = amount 0 with coin 1 -> Number of coins required = 0
dp[1][1] = amount 1 with coin 1 -> Number of coins required = 1
dp[2][4] = amount 4 with coins[1,2] - > Number of coins required = min(dp[1][4], dp[2][4 - 2] + 1)

return dp[rows][cols]
"""
class Solution:   
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins)==0:
            return -1
        rows = len(coins)
        cols = amount
        
        dp = [[0 for col in range(cols+1)] for  row in range(rows+1)]
   
        for i in range(1):
            for j in range(1,len(dp[0])):
                dp[i][j] = amount+1
        
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j],1+dp[i][j-coins[i-1]])
        
        if dp[rows][cols] > amount:
            return -1
        return dp[rows][cols]

