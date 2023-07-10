#Coin Change
class Solution(object):
    def coinChange(self, coins, amount):
        n = len(coins)
        dp = [[0] * (amount + 1) for _ in range(n + 1)]

        for j in range(1, amount + 1):
            dp[0][j] = amount + 1

        for i in range(1, n + 1):
            for j in range(1, amount + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])

        if dp[n][amount] >= amount + 1:
            return -1
        else:
            return dp[n][amount]

#Robber
class Solution:
    def rob(self, nums):
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        
        n = len(nums)
        path = [False] * n
        prev = nums[0]
        path[0] = True
        curr = max(nums[0], nums[1])
        
        if max(nums[0], nums[1]) == nums[1]:
            path[1] = True
        else:
            path[1] = False
        
        for i in range(2, n):
            temp = curr
            
            if max(curr, nums[i] + prev) == nums[i] + prev:
                path[i] = True
            else:
                path[i] = False
            
            curr = max(curr, nums[i] + prev)
            prev = temp
        
        print(path)
        out = ""
        i = n - 1
        while i >= 0:
            if not path[i]:
                i -= 1
            if path[i]:
                out += str(nums[i]) + ","
            i -= 2
        
        print(out)
        return curr

    
      

