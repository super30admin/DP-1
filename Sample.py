# // Time Complexity :O(m*n)
# // Space Complexity :O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Yes. Took a long time to understand. Not sure if I still completely do


// Your code here along with comments explaining your approach
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        def helper(coins,idx,amount,memo):
            #base case
            if amount == 0:
                return 0
            if idx == len(coins) or amount < 0:
                return float('inf')
            if memo[idx][amount] != 0:
                return memo[idx][amount]

            # if coin not choosen 
            case1 = helper(coins, idx+1, amount,memo)
            # if coin choosen
            case2 = 1 + helper(coins, idx, amount - coins[idx],memo)
            memo[idx][amount] = min(case1,case2)
            return memo[idx][amount]

        m=len(coins)
        n=amount
        memo = [[0] * (n + 1) for _ in range(m+1)]
        print(memo)

        res = helper(coins,0,amount,memo)
        if res == float('inf'):
            return -1
        print(memo)
        return res

# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Yes. Took a long time to understand. Not sure if I still completely do

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]

        n = len(nums)
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0],nums[1])
        for i in range(2,len(nums)):
            dp[i] = max(dp[i-1],nums[i]+dp[i-2])
        return dp[-1]

