# TimeCOmpelxity:O(N)
# SpaceComplexity:O(1)
# Approach:
# Try greedy it fails ([10,1,2,100])
# Exaustive has 2 variations one with for  loop and one with 0,1 rexursion but there are a lot of repeated subproblems
# DP:start from last  dp[i]= max(dp[i+2]+nums[i],dp[i+1]) why? adajcent houses cannnot be robbed
# space can optimized ..we jsut need 2 vals ..we can override them again and again



#----------------------------
# Space optimal
#----------------------------

class Solution:
    def rob(self, nums: List[int]) -> int:
        dp=[nums[-1],0]
        if len(nums)==1:
            return nums[0]
       
        for i in range(len(nums)-2,-1,-1):
            t=dp[0]
            dp[0]= max(dp[1]+nums[i],dp[0])
            dp[1]=t
            # print(dp[i])
        # print(dp)
        return dp[0]
#----------------------------
# normal DP
#----------------------------
class Solution:
    def rob(self, nums: List[int]) -> int:
        dp=[0 for _ in range(len(nums)+1)]
        if len(nums)==1:
            return nums[0]
        dp[-2]=nums[-1]
        for i in range(len(nums)-2,-1,-1):
            
            dp[i]= max(dp[i+2]+nums[i],dp[i+1])
            print(dp[i])
        print(dp)
        return dp[0]


#----------------------------
# 01 recursion
#----------------------------
class Solution:
    def rob(self, nums: List[int]) -> int:
        ans=[0]
        n=len(nums)
        
        def helper(i):
            if i >= len(nums):
                return 0
            return max(nums[i] + helper(i + 2), helper(i + 1))
                
                
            
        return helper(0)
        return ans[0]
#----------------------------
# for loop based recursion
#----------------------------
class Solution:
    def rob(self, nums: List[int]) -> int:
        ans=[0]
        n=len(nums)
        
        def helper(nums,idx,n,curr_Sum):
            #base
            if idx>=n:
                ans[0] = max(ans[0], curr_Sum)
                return
               
            #logic
            for i in range(idx,n):
                #pick
                helper(nums,i+2,n,curr_Sum+nums[i])
                #notpick
                
                
            
        helper(nums,0,n,0)
        return ans[0]
