# Time complexity
O(M*N)
# Space complexity
O(M*N)

# because of Table where M is amount+1 and N is number of coins +1

#  yes code ran succesfully on Leetcode


class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if coins is None or not coins:
            return 0
        dp = [[0 for j in range(amount +1)] for i in range(len(coins)+1)]
        dp[0][0]=0
#         top row
        print(len(dp[0]))
        for j in range(1,len(dp[0])):
            dp[0][j] = amount +1
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp [i-1][j]
                else :
                    dp[i][j] = min (dp [i-1][j], 1 + dp[i][j - coins[i-1]])
                           
        result = dp[len(dp)-1][len(dp[0])-1]
        if result > amount:
            return -1
        return result
                        
