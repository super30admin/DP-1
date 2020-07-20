#Time complexity: O(a*n) where a is the amount and n is the number of coins
#Space complexity: O(a) where a is the amount
#Works on leetcode: yes
#Approach:Here dp is an array to store the least amount of coins we need to make up a certain amount of money, 
#the index of dp means the amount of money to make up, so dp[x] means to make up money amount x 
# how many coins we need at least
class Solution(object):
    #function to find the fewest amount
    def coinChange1(self, coins, amount):
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
    
    #second function to get the fewest amount
    def coinChange2(self, coins, amount):
        return self.helper(coins, amount,0,0)
    #helper recursive function for base solution
    # Time = O(2^(n/min(coins)))
    # Space = O(n) for recursive stack
    def helper(self, coins, remaining, ind, currentcoins ):
        if (remaining<0) or (ind > len(coins)-1):
            return -1
        if remaining==0:
            return currentcoins
        #dont take the coin
        case1 = self.helper(coins, remaining, ind+1, currentcoins)
        #take the coin
        case2 = self.helper(coins, remaining - coins[ind], ind, currentcoins+1)
        if case1==-1:
            return case2
        if case2==-1:
            return case1
        return min(case1, case2)