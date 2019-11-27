# Time Complexity : Brute Force: O(S^n) S:target, DP: O(n*S)
# Space Complexity : Brute Force: O(S^n) S:target, DP: O(n*S)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

class Solution(object):
    def __helper(self, coins, numberOfCoins, remainingAmount, index):
        # base case
        if index >= len(coins) or remainingAmount < 0:
            return -1
        if remainingAmount == 0:
            return numberOfCoins
        
        # choose 
        numOfCoinsChoose = self.__helper(coins, numberOfCoins + 1, remainingAmount - coins[index], index)
        # not choose
        numOfCoinsNotChoose = self.__helper(coins, numberOfCoins, remainingAmount, index + 1)
        
        if numOfCoinsChoose == -1:
            return numOfCoinsNotChoose
        elif numOfCoinsNotChoose == -1:
            return numOfCoinsChoose
        else:
            return min(numOfCoinsChoose, numOfCoinsNotChoose)
        
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        sortedCoins = sorted(coins)
        return self.__helper(sortedCoins, 0, amount, 0)
        

class Solution2(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = [[None for i in range(amount + 1)] for j in range(len(coins) + 1)]
        rows = len(dp)
        cols = len(dp[0])
        for i in range(rows):
            dp[i][0] = 0
        for i in range(1,cols):
            dp[0][i] = float('inf')
        
        for i in range(1, rows):
            for j in range(1, cols):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i][j-coins[i-1]]+1, dp[i-1][j])
        result = dp[rows-1][cols-1]
        if result == float('inf'):
            result = -1
        return result

coins = [1,2,5]
amount = 11
obj = Solution()
obj2 = Solution2()
print(obj.coinChange(coins, amount))
print(obj2.coinChange(coins, amount))
