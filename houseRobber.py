#Space Optimization - O(N) time and O(1) space
class Solution:
    def rob(self, nums: List[int]) -> int:
        rob1,rob2=0,0
        for n in nums:
            temp=max(n+rob1,rob2)
            rob1=rob2
            rob2=temp
        return rob2

#Tabulation
#class Solution:
    # def rob(self, nums: List[int]) -> int:
    #     n=len(nums)
    #     dp = [-1]*len(nums)
    #     dp[0] = nums[0] 
    #     for i in range(1,n):
    #         pick = nums[i]
    #         if i>1:
    #             pick+=dp[i-2]
    #         notpick = dp[i-1]
    #         dp[i] = max(pick,notpick)
    #     return dp[n-1]
        
#Memoization
#class Solution:
    # def rob(self, nums: List[int]) -> int:
    #     n=len(nums)
    #     dp = [-1]*(n)
    #     def f(n):
    #         if n==0: return nums[n]
    #         if n<0: return 0 
    #         if dp[n]!=-1: return dp[n]
    #         pick = nums[n] + f(n-2)
    #         notpick = 0 + f(n-1)
    #         dp[n] = max(pick,notpick)
    #         return dp[n]
    #     return f(n-1)
        
#Recursion 
#class Solution:
    # def rob(self, nums: List[int]) -> int:
    #     n=len(nums)
    #     def f(n):
    #         if n==0: return nums[n]
    #         if n<0: return 0 
    #         pick = nums[n] + f(n-2)
    #         notpick = 0 + f(n-1)
    #         return max(pick,notpick)
    #     return f(n-1)
        