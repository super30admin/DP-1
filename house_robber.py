// Time Complexity : O(n) where n is size of nums array
// Space Complexity : O(n*2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: We make use of DP to solve this, as our current choice of robbing the
// house depends on the previous choices, and the dp array keeps track of the choices we made at each house in nums array. 
// ultimately we take max of the elements at last index of dp array. This gives us the max amt of money collected 


class Solution:
    def rob(self, nums: List[int]) -> int:
        if(len(nums)==0):
            return(0)
        dp=[[0 for i in range(2)] for j in range(len(nums))]
        dp[0][0]=0
        dp[0][1]=nums[0]
        for i in range(1,len(nums)):
            for j in range(2):
                # choose ==1, dont choose ==0
                if(j==0):
                    dp[i][j]=max(dp[i-1][1],dp[i-1][0])
                else:
                    dp[i][j]= nums[i] + dp[i-1][0]
        
        return(max(dp[len(nums) -1][0], dp[len(nums)-1][1]))