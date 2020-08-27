# Time Complexity : O(nm)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Previosuly, I solved using Top Down approach changed it to Bottom Up

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = [float('inf') for _ in range(amount + 1)]
        
        dp[0] = 0
        
        for coin in coins:
            for current_amount in range(1, (amount + 1)):
                if coin <= current_amount:
 #As we want minimum value of coins required to make the current amount, 
 # check the value at the current_amount without including the current coin and including the current coin which in turns result in adding 1 
 # and checking the value equal to cuurent_amount - current_coin
                    dp[current_amount] = min(dp[current_amount], 1 + dp[current_amount - coin])     
        return dp[amount] if dp[amount] != float('inf') else -1

s = Solution()
print s.coinChange([1,2,5], 11)
