'''Recursion without Memoisation Analysis'''
# Time Complexity : C^(A) where C is the number of coins and A is the amount we are trying to achieve.
# This is because we can have the deepest recursion stack to be of depth A. That is the height of our tree.
# At each depth we have C number of coins. Draw parallels to the binary tree. In the binary tree C = 2 and we get total number
# of nodes as 2^(Height) - 1.
# Hence, here total number of nodes are C ^ (A). Each node evaluation is constant time. Hence, complexity is C ^ (A).
# Space Complexity : O(A) the deepest recursion stack.


'''Recursion with Memoisation Analysis'''
# Time Complexity : A*C where A is the Amount and C is the number of coins. 
# This is because in the worst case the depth of the recursion could be A. 
# For each intermediate denomination of A, our result will be cached. Hence, the size of our tree will be A*C at most.

# Space Complexity : A (The size of the memo and the deepest recursion stack.)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No.


# Your code here along with comments explaining your approach

class MemoisedRecursion:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        def recur(target, memo):
            if target < 0:
                return -1
            
            if target == 0:
                return 0
            
            if target in memo:
                return memo[target]
            
            minCoins = -1
            for coin in coins:
                numCoins = recur(target - coin, memo)
                if numCoins != -1:
                    numCoins += 1
                    if minCoins == -1 or numCoins < minCoins:
                        minCoins = numCoins
            
            memo[target] = minCoins
            return memo[target]
        
        
        
        
        return recur(amount, {})


'''1D DP Solution'''
# Time Complexity : O(A*C)
# Space Complexity : O(A)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class DynamicProgramming:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        dp = [(amount + 1)] * (amount + 1)
        dp[0] = 0
        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] = min(dp[i], dp[i - coin] + 1)
        
        if dp[-1] == (amount + 1):
            return -1
        else:
            return dp[-1]