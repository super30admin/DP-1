# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(m * n), where m = number of coins & n = total amount
# Space Complexity : O(m * n), where m = number of coins & n = total amount
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Miscalculated the coins[i-1] in line 32 and missed condition in line29

class Solution:
    """
    Considering a matrix of total cols = amount 
    and total rows = number of coins. Any instance of matrix
    will tell the minimum coins used out of [0, row_no] to
    equal 'col_no' amount.
    """
    def coinChange(self, coins, amount: int) -> int:
        # considering each value will never exceed total amount
        maxvalue = amount + 3
        result = [[None for i in range(amount + 1)] for j in range(len(coins) + 1)]
        result[0][0] = 0    
        for i in range(1, amount + 1):
            result[0][i] = maxvalue 
        
        for j in range(1, len(coins) + 1):
            result[j][0] = 0
        
        for i in range(1,len(coins) + 1):
            for j in range(1, amount + 1):
                # the first few cols < coin value at that row will always
                # fetch from above them as left will go out of bound
                if j < coins[i -1]:
                    result[i][j] = result[i - 1][j]
                else:
                    result[i][j] = min(result[i - 1][j], result[i][j - coins[i - 1]] + 1)
        
        if result[len(coins)][amount] == maxvalue:
            return -1
        else:
            return result[len(coins)][amount]

# testing method:         
def test_coinChange():
    s = Solution()
    coins = [1, 2, 5]
    amount = 11
    expected_output = 3
    assert s.coinChange(coins, amount) == expected_output


test_coinChange()
