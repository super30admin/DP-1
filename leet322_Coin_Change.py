# Solution

# // Time Complexity : O(2^(m+n)) - In first exhaustive solution, since at each number we can have two outputs, either we choose 
#                      or we do not choose. If we follow the same, from root, to second level there will be 1*2 = 2 nodes
#                      In third level, for each node of second level will have two options. So that would be 4 nodes in third level.
#                      Max size/height will be m+n, where m is the ((amount/minimum coin)-1) and n is the length of array.
# 
#                      O(m*n) - Since we can use 2D matrix to save the values of already solved overlapping subproblems and overall
#                      matrix will be coins(row)Xamounts(columns). So we will do m*n iterations where we are actually finding
#                      something and then rest of the exhaustive will be just using what is already available, so it does not
#                      become exhaustive, recursion will exit if we are thinking in recursive angle. But here we go through
#                      2D Matrix route, so we dont do recursion.
# // Space Complexity : O(m+n) - For Exhaustive, since in recursion implicit stack will be max of height since we are considering
#                       choose/dont choose option causing recursion to look like a binary tree. Max height will me m+n, where m
#                       is (amount/mincoin)-1 and n is size of coins array. This is because if we keep selecting mincoin and 
#                       in last but one level, we can decide to select one coin other than min and then got to next level, then
#                       again select a different coin. If we keep going, max height will be m+n
#                       
#                       O(m) - m is amount, since we can use a list of size == amount, instead of 2D Matrix. Since we generally
#                       access just one row before to get current row and the last row's value will have the result
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach1 - Exhaustive approach - Use recursion, once for we choose that coin or one recursion if we do not choose the coin.
#             If the amount becomes negative then the traverse/recursion done till now will not give required result so it can
#             be ignored. If amount reaches then it is valid and we can take iterations which give minimum value
# Approach2 - Use 2D array(Just a list can be used since in this question we only need one row before), whatever we do in recursion
#             same values can be saved here and used. Approach is almost similar but using 2D matrix to save same sub problem values

def coinChange(coins,amount):
    
    # DP 2D Array->just one row to optimize space
    length = len(coins)
    arr = []
    for _ in range(0,amount+1):
        arr.append(999999999)

    arr[0] = 0

    for i in range(0,length):
        for j in range(1,amount+1):
            if j >= coins[i]:
                arr[j] = min( arr[j], 1 + arr[j - coins[i]])
    
    if arr[amount] >= 999999999:
        return -1
    else:
        return(arr[amount])



    # Exhaustive solution, for each number either pick or not
    # def helper(coins,amount,index,coinsUsed):
    
    #     if amount < 0 or index >= len(coins):
    #         return float(inf)
        
    #     if amount == 0:
    #         return coinsUsed

    #     case1 = helper(coins,amount-coins[index],index,coinsUsed+1)
    #     case2 = helper(coins,amount,index+1,coinsUsed)
    #     return min(case1,case2)
    
    # coinsUsed = helper(coins,amount,0,0)
    # if coinsUsed == float(inf):
    #     return -1
    
    # return coinsUsed

if __name__ == "__main__":
    coins = [1,2,5]
    amount = 11
    print(coinChange(coins,amount))