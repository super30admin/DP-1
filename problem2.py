// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach 1
// Time Complexity : O(n) //as m is constant
// Space Complexity : O(n) 
// Your code here along with comments explaining your approach
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        
        n=len(nums)
        m=2
        dp=[[0]*m for i in range(n) ]
        print(dp)
        
        dp[0][0]=nums[0]
        dp[0][1]=0
        print(dp)
        
        for i in range(1,n):                #Choose=0, Don't Choose=1
            for j in range(m):
                if j==0:
                    dp[i][j]=dp[i-1][1]+nums[i]     #if we choose current house then total amount will be previous don't choose+ current amount
                else:
                    dp[i][j]=max(dp[i-1][0],dp[i-1][1])  #if we don't choose current house then the amount will be max of previous chosen or not chosen house
        
        print(dp)
        return max(dp[n-1][0],dp[n-1][1])
        
        
//Approach 2
// Time Complexity : O(n) 
// Space Complexity : O(1) 
// Your code here along with comments explaining your approach
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        
        c=nums[0]
        dc=0
        for i in nums[1:]:     
            temp=dc
            dc=max(c,dc)
            c=temp+i
            
        return max(c,dc)
