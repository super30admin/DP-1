# time complexity:2 for loops , 0(nm) , n is the amount , m is the no of coins
#space complexity:0(n)
class Solution(object):
    def coinChange(self, coins, amount):
        
        if amount == 0:
            return 0
        
        dp = [amount+1]*(amount+1)
        dp[0] = 0
        for index in range(amount+1):
            for j in range(len(coins)):
                if coins[j] <= index:
                    dp[index] = min(dp[index],1+dp[index - coins[j]])
        
        
        if dp[amount] >= amount +1:
            return -1
        return dp[amount]
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        