"""
You are given an integer array coins representing coins of different
 denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

// Time Complexity : O(A* N),  A= amount of change, N = amount of coins
// Space Complexity : O(A)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : syntax


// There are 2 approaches, top down and bottom up


"""


2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
class Solution:
    def leastCoins(self, coins, amount):
        '''
        :type coins: list of int
        :type amount: int
        :rtype: int
        '''

        # This table will store the answer to our sub problems
        dp = [amount + 1] * (amount + 1)

        '''
        The answer to making change with minimum coins for 0
        will always be 0 coins no matter what the coins we are
        given are
        '''
        dp[0] = 0

        # Solve every subproblem from 1 to amount
        for i in range(1, amount + 1):
            # For each coin we are given
            for j in range(0, len(coins)):
                # If it is less than or equal to the sub problem amount
                if coins[j] <= i:
                    # Try it. See if it gives us a more optimal solution
                    dp[i] = min(dp[i], dp[i - coins[j]] + 1)

        '''
        dp[amount] has our answer. If we do not have an answer then dp[amount]
        will be amount + 1 and hence dp[amount] > amount will be true. We then
        return -1.
  
        Otherwise, dp[amount] holds the answer
        '''

        return -1 if dp[amount] > amount else dp[amount]


"""

Identify a recursive solution. Here the recurrence relation is:
rec_coin_change(amount) = min coin ∈ coins(rec_coin_change(amount-c)) + 1 ,if amount >= c
The recurrence should ultimately reduce to some base case. Here that is rec_coin_change(0) = 0. 
This is half the work done, but this is also the most difficult part. There is no DP without recursion. 
Jumping right into an iterative solution is seldom fruitful.

Find the subproblems. Try your recursive function on some dummy input and see what subfunctions are being called, 
whether any of them are called multiple times. We do not want to call the same function again and again.


Find the memoization data structure. Find how you can store the solutions to the intermediate subproblems,
 generally in an array, so that you don't have to recompute them. Figure out how many cells you nedd in the 
 data structure to fit all the various subproblems. Sometimes you can get away with writing just the memoized solution,
  that is recursion with a memory.

Identify the dependencies. What other subproblem(s) does a subproblem depend upon? Draw a diagram of the aforementioned
 data structure with arrows pointing to an arbitrary subproblem from the subproblems it depends upon (A DAG basically).
  https://i.imgur.com/5O1OCba.png

Figure out an evaluation order. Table filling time! We want to fill the base cases first. 
Then we fill the cells which depend on the base cases only, and then the cells depending on the previous cells, 
and so on. We must fill the cells at the tail end of the arrows before we can fill the cells at the head of the arrows. 
This is the iteration step. This is often confusing to me and the source of many bugs.

"""