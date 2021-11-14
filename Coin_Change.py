""" Time Complexity :
 Space Complexity :
 Did this code successfully run on Leetcode :
 Any problem you faced while coding this :


 Your code here along with comments explaining your approach """

def helper(coins, amount: int, count: int) -> int:
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
        return min(case1,case2)


def coinChange(coins, amount) -> int:
    return helper(coins, amount, 0)


output = coinChange([1,2,5], 11)
print(output)

