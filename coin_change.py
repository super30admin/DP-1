class Solution:
    # def coin_helper(self, coins, i, amount, count):
    #     if(amount<0):
    #         return -1
    #     if(i==len(coins)):
    #         return -1
    #     if(amount==0):
    #         return count
    #     case1=self.coin_helper(coins, i+1, amount, count)
    #     case2=self.coin_helper(coins, i, amount-coins[i], count+1)

    #     if(case1==-1):
    #         return case2
    #     elif(case2==-1):
    #         return case1
    #     return min(case1, case2)

    def coinChange(self, coins: List[int], amount: int) -> int:
        dp_matrix=[[None for i in range(amount+1)] for j in range(len(coins)+1)]
        dp_matrix[0][0]=0
        for i in range(1,amount+1):
            dp_matrix[0][i]=amount+1
        for i in range(1, len(coins)+1):
            for j in range(amount+1):
                if(coins[i-1]>j):
                    dp_matrix[i][j]=dp_matrix[i-1][j]
                else:
                    dp_matrix[i][j]=min(dp_matrix[i-1][j], dp_matrix[i][j-coins[i-1]]+1)        
        if(dp_matrix[len(coins)][amount]==amount+1):
            return -1
        return dp_matrix[len(coins)][amount]


    