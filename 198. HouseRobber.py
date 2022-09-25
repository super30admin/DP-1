# Passed on Leet Code
## Recurssion

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        def helper(nums,index,count):
            ## base case
            if len(nums) <= index:
                return count
            
            # case 1 not choose
            case1 = helper(nums,index+1,count)
            # case2 choose
            case2 = helper(nums,index+2,count+nums[index])
            
            return max(case1,case2)
        return helper(nums,0,0)
#DP
#TC: 0(N)
#SC: 0(N)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        n = len(nums)
        dp = [[0]*2for i in range(n+1)]
        
        dp[0][1] = nums[0]
        print(dp)
        for i in range(n):
            # do not rob case
            dp[i][0]= max(dp[i-1][0],dp[i-1][1])
        # rob case
            dp[i][1]=dp[i-1][0]+nums[i]
        return max(dp[n-1][0],dp[n-1][1])

#DP
#TC: 0(N)
#SC: 0(1)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        n = len(nums)
        skip=0
        take=nums[0]
        for i in range(1,n):
            temp=skip
            skip=max(skip,take)
            take=temp+nums[i]
        return max(skip,take)



