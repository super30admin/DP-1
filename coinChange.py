# Time Complexity : O(2^k) k:target
# Space Complexity : O(2^k) k:target
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : Not able to come up with optimized solution

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
        

coins = [1,2,5]
amount = 11
obj = Solution()
print(obj.coinChange(coins, amount))
