from typing import List

# recursive solution
# class Solution:
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         if coins == None or len(coins) == 0:
#             return 0
#         return self.helper(coins, amount, 0, 0)
    
#     def helper(self, coins: List[int], amount: int, index: int, minimum: int) -> int:
#         if amount == 0:
#             return minimum
#         if index == len(coins) or amount < 0:
#             return -1
        
#         case1 = self.helper(coins, amount - coins[index], index, minimum + 1)
#         case2 = self.helper(coins, amount, index + 1, minimum)
        
#         if case1 == -1:
#             return case2
#         if case2 == -1:
#             return case1
        
#         return min(case1, case2)


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins == None or len(coins) == 0:
            return 0
        
        dp = [[0 for j in range(amount + 1)] for i in range(len(coins) + 1)]
        
        # fill the first column
        for i in range(len(dp)):
            dp[i][0] = 0
            
        for j in range(1,len(dp[0])):
            dp[0][j] = amount + 1
            
        for i in range(1, len(dp)):
            for j in range(1,len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])
        
        result = dp[len(dp)-1][len(dp[0])-1]
        if result > amount:
            return -1
        return result

obj = Solution()
print(obj.coinChange([1,2,5], 11))
print(obj.coinChange([2], 3))
print(obj.coinChange([1], 0))
print(obj.coinChange([1], 1))
print(obj.coinChange([1], 2))

# Time Complexity: n * m where n is len of coin array and m is amount
# Space Complexity: n * m where n is len of coin array and m is amount