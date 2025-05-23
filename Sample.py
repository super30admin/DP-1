# Problem 1: Coin Change
# Time Complexity : O(amount*n)
# Space Complexity : O(amount)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp=[float('inf')]*(amount+1)
        dp[0]=0
        if amount==0:
            return 0
        for i in coins:
            for j in range(1,amount+1):
                if j-i>=0:
                    dp[j]=min(dp[j],dp[j-i]+1)
        
        if dp[-1]==float('inf'):
            return -1
        else:
            return dp[-1]



# Problem 2: House Robbery
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def rob(self, nums: List[int]) -> int:
        fi=[0]
        si=[nums[0]]
        if len(nums)==1:
            return nums[0]
        
        for i in range(1, len(nums)):
            fi.append(max(si))
            si.append(nums[i]+max(fi[:-1]))

        return max(fi[-1],si[-1])

