# // Time Complexity : O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :no
class Solution:
    def rob(self, nums):
        #optimized versionof dp  
        rob1=0
        rob2=0
        
        for m in nums:
            #so for our array we say we ahave aaraay like rob1,rob2,m,m+1,m+2..
            temp=max(rob1+m,rob2)
            rob1=rob2
            rob2=temp
        #because by the time we finsihed looking our aaray rob2 will be pointing to the max profit so far    
        return rob2
    #TC O(n) SC O(1)

  #DP version with space complexity O(n)  
class Solution:
    def rob(self, nums):
                    
        #dp table for range upto last house money
        max_rob_dp=[None for n in range(len(nums)+1)]
        hl=len(nums)
        
           #base case initializations
        max_rob_dp[len(nums)]=0
           #base case initializations 

        max_rob_dp[hl-1]=nums[hl-1]

        for i in range(hl-2,-1,-1):

            max_rob_dp[i]= max(nums[i] + max_rob_dp[i+2], max_rob_dp[i+1])

        return max_rob_dp[0]
            
            
        

        
