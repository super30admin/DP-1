#Time complexity: O(a*n) where a is the amount and n is the number of coins
#Space complexity: O(a) where a is the amount
#Works on leetcode: yes
#Approach:Here dp is an array to store the least amount of coins we need to make up a certain amount of money, 
#the index of dp means the amount of money to make up, so dp[x] means to make up money amount x 
# how many coins we need at least
class Solution(object):
    #function to find the fewest amount
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = [amount+1 for i in range(amount+1)]
        dp[0]=0
        for i in range(1,amount+1):
            for j in range(len(coins)):
                if coins[j]<=i:
                    dp[i]=min(dp[i], dp[i-coins[j]]+1)
        return dp[amount] if dp[amount]<=amount else -1
        