"""
// Time Complexity : O(C * A) -> A -> Amount, C -> size of coins array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach
Algorithm explanation
- Recursive approach
    - We build the tree based on two decisions - to choose a coin and to not choose 
    a coin
    - Choosing a coin, will imply
        - same coin can be used again
        - reducing the total amount by coin value
    - Not choosing a coin will imply
        - Moving to next coin
        - keeping the amount as it is
    - Base case
        - amount == 0 -> return the count of coins
        - amount < 0 or all coins have been used:
            return -1
    - Recursive formulation
        - return min of value returned by choosing coin and not choosing the coin




1) We approach this problem as minimization of optimal subproblem for each coin
selected to sum up the target amount
2) We consider a singular tabular representation (dp)
    - Update dp array as min of prev value and for each value of coins such that coin
    is less than or equal to amount
3) Return dp[amount]
"""
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        #Rec approach
        def rec_coin_change(coins,i,amount, count):
            if amount == 0:
                return count
            if amount < 0 or i == len(coins):# exhausted the coins, return -1, because no comination found till now
                return -1
            
            choose_coin = rec_coin_change(coins,i,amount-coins[i],count+1)
            dont_choose_coin = rec_coin_change(coins,i+1,amount,count)
            
            if choose_coin == -1: return dont_choose_coin
            if dont_choose_coin == -1: return choose_coin
            return min(choose_coin,dont_choose_coin)
        
        return rec_coin_change(coins,0, amount, 0)


        #DP Approach
        dp = [9999+1]*(amount+1)
        dp[0] = 0
        
        for i in range(amount+1):
            for coin in coins:
                if coin <= i:
                    dp[i] = min(dp[i],dp[i-coin]+1)
        
        print(dp)
        
        if dp[amount] >= 9999:
            return -1
        return dp[amount]