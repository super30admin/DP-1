
"""
https://leetcode.com/problems/coin-change/
Approach is given below
Tc: O(n square)
Sc: O(n square)
Ran on leetcode-yes

"""

class Solution:
    def coinChange(self, coins, amount: int) -> int:
        if len(coins)==0:
            return 0
        dpMatrix=[[0 for x in range(amount+1)] for y in range(len(coins)+1)]
        dpMatrix[0][0]=0
        # dpMatrix

        ##first making all columns of row 0 to inf except the 0th column
        for j in range(1, len(dpMatrix[0])):
            dpMatrix[0][j]=amount+1
        # print(dpMatrix)

        ##now calculating the amount on the rest of the rows
        for i in range(1, len(dpMatrix)):
            for j in range(1, len(dpMatrix[0])):

                ##if amount is less than denomination of the coin

                ##in matrix i=1 is coin 2 but actually coins[i-1==0]= coin 2 so we did i-1
                if j < coins[i-1]:

                    ##zero case - not chose

                    dpMatrix[i][j]=dpMatrix[i-1][j]


                else:

                    ## min of zero case the row above or chosing
                    # chosing=dpMatrix[i][j-coins[i-1]]
                    # # chosing+=1
                    dpMatrix[i][j]=min (dpMatrix[i-1][j],  1+ dpMatrix[i][j-coins[i-1]] )
                    # min(a,b)


        result=dpMatrix[len(dpMatrix)-1][len(dpMatrix[0])-1]
        if result>amount:
            return -1
        else:
            return result

        # return dpMatrix[len(dpMatrix)-1][len(dpMatrix[0]-1)]


# columns=12
# rows=4


coins = [1, 2, 5]
amount = 11
solve=Solution()
print(solve.coinChange(coins,amount))
# matrix=[[0 for x in range(amount+1)] for y in range(len(coins)+1)]

# print(matrix)

#
# ###below function will be the recursive function
# class Solution:
#     def coinChange(self, coins, amount):
#         if len(coins)==0:
#             return 0
#         return self.helper(coins, amount, 0, 0)
#
#     def helper(self, coins, amount, index, minCoins):
#
#         """
#         basecase
#         """
#
#         if amount==0:
#             return minCoins
#
#         if index==len(coins) or amount<0:
#             return -1
#
#
#         """
#         logic
#         """
#         ##yahan pe index badal raha hai aur amount badal raha hai
#
#         ###chose
#         case1=self.helper(coins, amount-coins[index], index, minCoins+1)
#
#         ###don't chose
#         case2=self.helper(coins, amount, index+1, minCoins)
#
#         if case1 == -1:
#             return case2
#
#         if case2 == -1:
#             return case1
#
#         return min(case1, case2)
#
#
#
#         # return coins
#
#         # return 0
# coins = [1, 2, 5]
# amount = 11
# # index=4
# # minCoins=2
# solve=Solution()
# print(solve.coinChange(coins, amount))
#

#
# from heapq import heap
