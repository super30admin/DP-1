## Problem1 (https://leetcode.com/problems/coin-change/)

# https://leetcode.com/problems/coin-change/

# Method1: Recursion
# m ----- no: of coins
# n ----- amount
# Time Complexity : O(2^(m + n)) -- At every step, we have two choice to make and the max level or the max depth of the tree is m+n
# Space Complexity : O(1) space. But if we consider auxiliary space of the recursion stack, it would be O(m + n)
# Did this code successfully run on Leetcode : TLE
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Since greedy does not give us a valid result. So we try to be exhaustive in our search and explore all possible paths that would
# make our amount = 0 and we take the minimum number of coins at each step that would make our amount left = 0. Since our problem is
# based on problem -> subproblem -> subproblem -> subproblem -> subproblem, so we use recursion to solve. Since time complexity is 
# very high, it gives us TLE for higher values, but it would gives us correct result

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # recursive function
        def helper(coins, amount, idx):
            # base case
            # idx finishes or amount < 0
            if(idx == len(coins) or amount < 0):
                # this is invalid case, we cannot make the amount
                # since we are taking min, and this is not our 
                # valid case, so we need to return something that
                # would be rejected by our case. We cannot return -1 because it would always be smaller than any +ve number
                return float('inf')

            # if amount == 0, we are able to reach the target
            # If amount is already 0, what min coins do we need to make the amount 0 is None ie 0
            if(amount == 0):
                return 0

            # logic
            # ignore the coin
            case1 = helper(coins, amount, idx + 1)
            # choose the coin. idx remains same because we have infinite supply of coins
            case2 = 1 + helper(coins, amount - coins[idx], idx)

            # take min
            return min(case1, case2)
        
        # recursion approach
        # exploring all possibilities to get minimum number of coins
        re = helper(coins, amount, 0)
        if(re == float('inf')):
            re = -1

        return re
        
sol = Solution()
print("Method1: Recursion")
print(sol.coinChange([1,2,5], 11))
print(sol.coinChange([2], 3))
print(sol.coinChange([1], 0))

# Method2: Recursion with Memoization
# m ----- no: of coins
# n ----- amount
# Time Complexity : O(m * n)
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Using memoization to store the results of the repeated sub problems. It helps to reduce the time complexity of the recursion solution,
# by avoiding exploring subproblems that we have already solved before

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # Method - 2
        # Memoization - Top-bottom
        # We will build a similar table as in tabulation, but in top-bottom way. We will store the result of repeated sub problems based on the input variables
        #Create a 2-D array as we 2 input variables here. Amount and coins
        memo = []
        for i in range(len(coins)):
            memoRow = []
            for j in range(amount + 1):
                memoRow.append(-1)
            memo.append(memoRow)
                
        def helper(coins, amount, idx):
            # base case
            # idx finishes or amount < 0
            if(idx == len(coins) or amount < 0):
                # this is invalid case, we cannot make the amount
                # since we are taking min, and this is not our 
                # valid case, so we need to return something that
                # would be rejected by our case. We cannot return -1 because it would always be smaller than any +ve number
                return float('inf')

            # if amount == 0, we are able to reach the target
            # If amount is already 0, what min coins do we need to make the amount 0 is None ie 0
            if(amount == 0):
                return 0

            if(memo[idx][amount] != -1):
                # we have already solved this subproblem
                return memo[idx][amount]

            # logic
            # ignore the coin
            case1 = helper(coins, amount, idx + 1)
            # choose the coin. idx remains same because we have infinite supply of coins
            case2 = 1 + helper(coins, amount - coins[idx], idx)

            # take min
            memo[idx][amount] = min(case1, case2)
            return memo[idx][amount]
        
        # recursion approach
        # exploring all possibilities to get minimum number of coins
        re = helper(coins, amount, 0)
        if(re == float('inf')):
            re = -1

        return re
        

sol = Solution()
print("Method2: Recursion with Memoization")
print(sol.coinChange([1,2,5], 11))
print(sol.coinChange([2], 3))
print(sol.coinChange([1], 0))


# Method3: Bottom-up Tabulation
# m ----- no: of coins
# n ----- amount
# Time Complexity : O(m * n)
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# In the recursive solution above we see many repeated subproblems. So we know it is a Dynamic Programming problem. 
# In this I am using tabulation that is bottom-up approach to build the tree from the leaf that is from back. We know our first column
# of the dp matrix would always be 0 as it would be base case of our recursion where we need to return min number of coins required to 
# make the amount of 0. Here we use first row as dummy, storing min coins of denomination [0] required to make amount of 1,2,..... amount
# As these are invalid cases, so we store infinity there. Then we apply operation on our dp array handling two main cases. When 
# denomination of coin > current amount, then our min coins would always come from the above row that case 0 when we dont choose that coin.
# if denomination of coin <= current amount, then we the min(above row, 1 + min coins we got from denomination no. of steps back)


class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # Method - 3
        # Tabulation - Bottom-up

        # creating (m + 1) * (n + 1) table
        # m = no. of rows, with first row as dummy row
        # n = no. of cols, ranging from amount = 0 to amount, so amount + 1
        m = len(coins)
        n = amount
        dp = []
        for i in range(m + 1):
            dpCol = []
            for j in range(n + 1):
                if(j == 0):
                    # first col is base case of recursion, where amount = 0
                    dpCol.append(0)
                else:
                    if(i == 0):
                        # dummy first row, with invalid cases
                        dpCol.append(float('inf'))
                    else:
                        dpCol.append(-1)
            dp.append(dpCol)

        # apply operations on dp matrix to get min coins at every different amount based to 0,1 cases of recursion

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                # case when amount < denomination of the coin
                # if i-1 index for coins because we have a dummy row.
                # it is 0,2,1,5 for rows and
                # 2,1,5 for coins
                if(j < coins[i - 1]):
                    # case 0, just select from above row
                    dp[i][j] = dp[i - 1][j]
                else:
                    # case 1, when amount >= denomination of the coin
                    # choose min(above, 1 + denomination no. of steps back)
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])

        # our last index would contain the min number of coin required to make the amount with the given denominations
        if(dp[m][n] == float('inf')):
            # not possible to make the amount
            return -1
        return dp[m][n]

sol = Solution()
print("Method3: Bottom-up Tabulation")
print(sol.coinChange([1,2,5], 11))
print(sol.coinChange([2], 3))
print(sol.coinChange([1], 0))


# Method4: Bottom-up Tabulation with space optimization
# m ----- no: of coins
# n ----- amount
# Time Complexity : O(m * n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Now in this if we see closely we are relying only on one previous row result and the same row result for min coins used
# Then we don’t need to store all the rest rows of the matrix. As the earlier rows we are not using so we can optimize the space.
# If we just maintain a 1-D array and we keep overwriting on that as we apply operations to find min coins for a particular amount.

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # Method - 4
        # Tabulation - Bottom-up with 1-D array space

        # creating 1 * (n + 1) - 1 row matrix
        # n = no. of cols, ranging from amount = 0 to amount, so amount + 1
        n = amount
        m = len(coins)
        dp = []

        for j in range(n + 1):
            if(j == 0):
                # first col is base case of recursion, where amount = 0
                dp.append(0)
            else:
                # dummy first row, with invalid cases
                dp.append(float('inf'))

        # apply operations on dp matrix to get min coins at every different amount based to 0,1 cases of recursion

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                # case when amount < denomination of the coin
                # if i-1 index for coins because we have a dummy row.
                # it is 0,2,1,5 for rows and
                # 2,1,5 for coins

                # case 0, just select from above row
                # to update the current row with the above row, just let it be same
                # we remove this if block
                if(j >= coins[i - 1]):
                    # case 1, when amount >= denomination of the coin
                    # choose min(above, 1 + denomination no. of steps back)
                    dp[j] = min(dp[j], 1 + dp[j - coins[i - 1]])

        # our last index would contain the min number of coin required to make the amount with the given denominations
        if(dp[n] == float('inf')):
            # not possible to make the amount
            return -1
        return dp[n]
        
sol = Solution()
print("Method4: Tabulation - Bottom-up with space optimization")
print(sol.coinChange([1,2,5], 11))
print(sol.coinChange([2], 3))
print(sol.coinChange([1], 0))


# Follow-up to this question, how would you print all the exact coins that we were part of the answer
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # Method - 2
        # Tabulation - Bottom-up

        # creating (m + 1) * (n + 1) table
        # m = no. of rows, with first row as dummy row
        # n = no. of cols, ranging from amount = 0 to amount, so amount + 1
        m = len(coins)
        n = amount
        dp = []
        for i in range(m + 1):
            dpCol = []
            for j in range(n + 1):
                if(j == 0):
                    # first col is base case of recursion, where amount = 0
                    # storing (not choose, min coins)
                    dpCol.append([0, 0])
                else:
                    if(i == 0):
                        # dummy first row, with invalid cases
                        dpCol.append([0, float('inf')])
                    else:
                        dpCol.append([0, -1])
            dp.append(dpCol)

        # apply operations on dp matrix to get min coins at every different amount based to 0,1 cases of recursion

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                # case when amount < denomination of the coin
                if(j < coins[i - 1]):
                    # case 0, just select from above row
                    # update coins from above
                    dp[i][j][1] = dp[i - 1][j][1]
                else:
                    # case 1, when amount >= denomination of the coin
                    # choose min(above, 1 + denomination no. of steps back)
                    # 
                    if(1 + dp[i][j - coins[i - 1]][1] < dp[i - 1][j][1]):
                        # this coin was chosen in min coins for this amount
                        dp[i][j][0] = 1
                    dp[i][j][1] = min(dp[i - 1][j][1], 1 + dp[i][j - coins[i - 1]][1])

        # our last index would contain the min number of coin required to make the amount with the given denominations
        if(dp[m][n][1] == float('inf')):
            # not possible to make the amount
            return -1
        
        res = dp[m][n][1]
        # lets try to get the exact coins
        count = 0
        exactCoins = []
        while(count < res):
            if(dp[m][n][0]):
                # this coin was chosen
                exactCoins.append(coins[m - 1])
                # decrement by denomination steps
                n -= coins[m - 1]
                count += 1
            else:
                # this coin was not chosen, the min came from above row
                # decrement the row
                m -= 1

        print(exactCoins)
            
        return res

sol = Solution()
print("Method2: Tabulation - Bottom-up with printing exact coins")
print(sol.coinChange([1,2,5], 11))
print(sol.coinChange([2], 3))
print(sol.coinChange([1], 0))