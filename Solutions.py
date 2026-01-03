# Problem1 (https://leetcode.com/problems/coin-change/)
# Time Complexity : 
## exusative approach : 2 ^ M+N
## tabulation/memoization : O(MN)
# Space Complexity : 
## exusative approach : O(n)
## tabulation/memo : O(n)
## here M is amount and n is no of coins
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no

## The naive approach will be greedy to always take the highest/ lowest but in this case it will not work
## when the denomination is not conical, then it is not possible to make the sum using these coins
## I will then start exploring the exuastve solution, I will take all the coins either I choose or not choose
## this will be really expensive to do? Why ? because in the worst case the depth of the tree will be m+n 
## where m in the amount and n in number of coins. and totoal complexity becomes 2 ^ m+n
## Can we do anything better than this?? Lets start exploring dp - Bottom Up (tabulation) or top down (recursion)

## exuastive approach
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
    def helper(coins,amount,idx):
        ## base case if the amount becomes 0 
        if amount ==0 : return 0
        ## base case if I reach the end of coins or amount becomes neg
        if amount <0 or idx == len(coins):
            return float('inf')-10 ## need to return a big number so that while checking min this is not caught
        ## case 1 when I choose
        case1 = 1 + helper(coins, amount-coins[idx], idx)
        ## case 2 when I dont choose
        case2 = helper(coins, amount, idx+1)

        return min(case1,case2) ## why min? because I want min number of coins

    minCoin = helper(coins,amount, 0)
    if minCoin >= float('inf') -10:
        return -1 ## meaning I have tried everything
    return minCoin
## This solution passes some test cases but will give TLE
## Lets start with bottom up or tabulation, here how do I decide how many degree of array should I take? 1d or 2d?
## start by checking how many decision params we have and start there. Right now I have two coins, amount
## Lets start with 2d array and try to fill it
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        
        m= len(coins)
        n = amount
        ## initializing the array
        dp = [[0] * (n+1) for _ in range(m+1)]
        
        ## having the first row as big value, because base case
        for j in range(n+1):
            dp[0][j] = 99999
            
        for i in range(1,m+1):
            for j in range(1,n+1):

                ## if denomination is smaller than the amount
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                ## if the denomination is bigger, I can either choose the zero case or I can choose from already solved matrix
                else:
                    dp[i][j] = min(dp[i-1][j], 1+ dp[i][j-coins[i-1]])
        
        if dp[m][n] == 99999:
            return -1
        else:
            return dp[m][n]



## Lets start with top down, where I will try to it using recursion like in my exuastive approach
## either I take the coins or I dont take the coins, each time I can call the same function and go down from there

def helper(coins,amount,idx,memo):
    ## base case if the amount becomes 0 
    if amount ==0 : return 0
    ## base case if I reach the end of coins or amount becomes neg
    if amount <0 or idx == len(coins):
        return float('inf')-10 ## need to return a big number so that while checking min this is not caught
    if memo[idx][amount] != -1: ## adding extra condition to check of already solved then return from array
        return memo[idx][amount]
    ## case 1 when I choose
    case1 = 1 + helper(coins, amount-coins[idx], idx,memo)
    ## case 2 when I dont choose
    case2 = helper(coins, amount, idx+1,memo)

    memo[idx][amount] = min(case1,case2)
    return min(case1,case2) ## why min? because I want min number of coins

## introducing memo to store the results that we already calculated, initializing -1 meaning we have not calculated
memo = [[-1] * (amount+1) for _ in range(len(coins)+1)]
minCoin = helper(coins,amount, 0,memo)
if minCoin >= float('inf') -10:
    return -1 ## meaning I have tried everything
return minCoin


# Problem2 (https://leetcode.com/problems/house-robber/)
# Time Complexity : CASE1 : 2 ^ m+n CASE2/CASE3 : (MN)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


## CASE 1 : TLE exuastive approach
def helper(nums,idx):
            ## base case 
            if idx >= len(nums):
                return 0
            ## I can either choose to rob the house
            case1 = nums[idx] + helper(nums,idx+2)
            ## I dont rob the house
            case2 = helper(nums,idx+1)

            return max(case1,case2)
        
        
        mxrobbings = helper(nums,0)
        return mxrobbings


# CASE 2 : using memo 

def helper(nums,idx):
    ## base case 
    if idx >= len(nums):
        return 0
    if memo[idx] != -1:
        return memo[idx]

    ## I can either choose to rob the house
    case1 = nums[idx] + helper(nums,idx+2)
    ## I dont rob the house
    case2 = helper(nums,idx+1)
    memo[idx] = max(case1,case2)
    return max(case1,case2)

memo = [-1] * len(nums)
mxrobbings = helper(nums,0)
return mxrobbings

# CASE 3: using tabulation 

if len(nums) ==1:
    return nums[0]
dp = [-1]* (len(nums)+1)
dp[0] = nums[0]
dp[1] = max(nums[0], nums[1])

for i in range(2,len(nums)):
    
    ## to choose
    case1 = nums[i] + dp[i-2]
    ## to not choose
    case2 = dp[i-1]

    dp[i] =  max(case1,case2)

return dp[len(nums)-1] 