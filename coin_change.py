'''
# Solution 1: Recursion 
at each iteration, I have 2 options, choose/no-choose. 
Base condition: if remaining amount=0 | all types of coins considered | amount<0
Time complexity: O(2^(m+n)), n = number of coins, m = amount | height of tree
Space Complexity: O(1)
'''
# class Solution:
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         self.amount = amount
#         ans = self.helper(coins,amount,0)
#         if ans ==self.amount+1:
#             return -1
#         else:
#             return ans

#     def helper(self,coins, amount, idx):
#         # base
#         if amount ==0:
#             return 0 # amount matched, no more coins needed
#         if amount<0 or idx==len(coins): 
#             return self.amount+1

#         # Case 1: No Choose
#         case1 = 0 + self.helper(coins, amount, idx+1) 
#         # Case 2:  choose
#         case2 = 1 + self.helper(coins, amount-coins[idx], idx)

#         return min(case1, case2)


'''
# Solution 2: DP - matrix
rows = different denomination coins, 
cols = amount 
We'll add a dummy row with coin value = 0
Overlapping repeated sub-problems : with coin [2,5] to make amount 6 
Time complexity: O(m x n) , m = different denomination coins, n = Amount
Space Complexity: O(m x n), matrix (tabulation) 
'''
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins)+1 # dummy row with coin denomination=0
        n = amount+1 # starting from 0 ->amount
        max_val = amount + 1 # acts at +inf : we can never have total coins>amount
        dp_mat = [[None]*n for i in range(m)]

        # fill up the first row
        for i in range(n):
            dp_mat[0][i]=max_val # I can never achieve (or inf coins of val 0) the desired amount
        dp_mat[0][0] = 0 # with coin_val = 0, I need 0 coins to make amount 0

        for i in range(1,m):
            for j in range(n):
                # until denomination value is more than amount, no point of choosing this coin
                if coins[i-1] > j:
                    # only no choose option
                    dp_mat[i][j]=dp_mat[i-1][j] # [1,2], at 2 for amount 1. Not choosing 2, gives [1] for amount 1 which is row with coin=[1], col =1 amount
                else:
                    # choose/No-choose option, take minimum. For choose, add 1 coin
                    dp_mat[i][j] = min(dp_mat[i-1][j], 1+dp_mat[i][j-coins[i-1]]) # coins[i-1] is the denomination value

        if dp_mat[-1][-1] == max_val:
            return -1
        return dp_mat[-1][-1]

'''
# Solution 3: Recursion with memoization 
at each iteration, I have 2 options, choose/no-choose. I keep maintaining a hashMap
to store the values. {'start_idx-amount' : coins needed} Start idx tells me about how many
denominations I have. 
Base condition: if remaining amount=0 | all types of coins considered | amount<0
Time complexity: O(m x n), n = different denomination of coins, m = amount
Space Complexity: O(m x n)
'''
# class Solution:
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         self.amount = amount
#         self.mem = {}
#         ans = self.helper(coins,amount,0)
#         if ans ==self.amount+1:
#             return -1
#         else:
#             return ans

#     def helper(self,coins, amount, idx):
#         # base
#         if amount ==0:
#             return 0 # amount matched, no more coins needed
#         if amount<0 or idx==len(coins): 
#             return self.amount+1
        
#         # memory check
#         if (f"{idx}-{amount}") in self.mem:
#             return self.mem[f"{idx}-{amount}"] 
        
#         # Case 1: No Choose
#         case1 = 0 + self.helper(coins, amount, idx+1) 
#         # Case 2:  choose
#         case2 = 1 + self.helper(coins, amount-coins[idx], idx)
#         self.mem[f"{idx}-{amount}"] = min(case1,case2)
#         return min(case1, case2)
