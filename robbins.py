from typing import List
# #using the recursion
# class Solution:
#     def robins(self, house: List[int]) -> int:
#
#         if house is None : return -1
#         return  self.helper(house=house,index=0,robins=0)
#     # using the recursive approach
#     def helper(self,house: List[int], index: int, robins: int):
#         if index>=len(house): return robins
#
#         # logic
#         # for no coin selection case
#         case1 = self.helper(house=house,index=index+1,robins=robins)
#         # for coin selection case
#         case2 = self.helper(house=house,index=index+2,robins=robins+house[index])
#         return max(case1, case2)


# using the DP approach
class Solution:

    def robins(self, house: List[int], ) -> int:

        if house is None: return -1
        nrows =len(house)
         # creating the DP Matrix as we to keep track of amount and coins
        dp=[[0 for _  in range(0,2)]for _ in range(0,nrows)]
        # o filling in the first coliumn

        dp[0][1]=house[0]
        for hindex in range(1,nrows):
            dp[hindex][0]= max(dp[hindex-1][0],dp[hindex-1][1])
            dp[hindex][1]=house[hindex]+dp[hindex-1][0]

        return max(dp[nrows-1][0],dp[nrows-1][1])




if __name__ == '__main__':

    print(Solution().robins(house=[2,7,1,9,13]))

