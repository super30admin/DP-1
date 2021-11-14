""" 
 Time Complexity : O(amount * len(coins))
 Space Complexity : O(amount * len(coins))
 Did this code successfully run on Leetcode : yes
 Any problem you faced while coding this : No


 Your code here along with comments explaining your approach """

"""def helper(coins, amount: int, count: int) -> int:
    # base case
    if amount == 0:
        return count
    elif amount > 0 and len(coins)==0:
        return -1
    elif amount < 0:
        return -1
    #choose
    case1 = helper(coins, amount - coins[0], count+1)
    #notChose
    case2 = helper(coins[1:],amount, count)
    if case1 <= 0 and case2 <= 0:
        return -1
    elif case1 <=0:
        return case2
    elif case2 <= 0:
        return case1
    else:
        return min(case1,case2) """


def coinChange(coins, amount) -> int:
    #return helper(coins, amount, 0)
    dp = [[0 for _ in range(amount + 1)] for _ in range(len(coins)+1)]
    # filling the first row
    for i in range(1, len(dp[0])):
        dp[0][i] = amount + 1

    for i in range(1, len(dp)):
        for j in range(1, len(dp[0])):
            if coins[i-1] > j:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])
    
    return dp[len(dp)-1][len(dp[0])-1]


output = coinChange([1,2,5], 11)
print(output)



