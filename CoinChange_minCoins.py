class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        arr = [[None for _ in range(0,amount+1)] for _ in range(len(coins)+1)]
        for i in range(len(arr)):
            arr[i][0]=0
        for i in range(1,len(arr[0])):
            arr[0][i]=amount+1
        for i in range(1, len(arr)):
            for j in range(1, len(arr[0])):
                if coins[i-1]>j:
                    arr[i][j]=arr[i-1][j]
                else:
                    arr[i][j]=min(arr[i-1][j], 1+arr[i][j-coins[i-1]])
        result = arr[len(coins)][amount]
        if result>amount:
            return -1
        return result
        # print(arr)
        # [print(i) for i in len(arr)]
        
#         if not coins:
#             return 0
#         return self.helper(coins, amount, 0, 0)
    
#     def helper(self, coins:List[int], amount:int, index:int, mincoins:int):
#         if amount==0:
#             return mincoins
#         elif amount<0 or index>=len(coins):
#             return -1
        
#         case1 = self.helper(coins, amount-coins[index], index, mincoins+1)
#         case2 = self.helper(coins, amount, index+1, mincoins)
#         if case1==-1:
#             return case2
#         if case2==-1:
#             return case1
#         return min(case1, case2)


""" Time complexity - O(nm) where n is the number of coins and m is the amount given
# space complexity - O(nm) as we are utilizing array as the intermediate data structure for dynamic programming.

For the commented recursion code, the time complexity would be 2^n 
and space complexity O(n) where n is the number of coins"""
        