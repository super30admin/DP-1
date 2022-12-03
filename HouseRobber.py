# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
## we basically need to find out all the houses we need to pick to get the max amount . THe condition is that we cannot pick adjacent houses. 
## so it bowls down to a particular house at a time. wif we pick the house or we dont pick the house. 
## if pick the house then we cannot pick the previous house , but we can see the max amount if the previous of previous house and ad dit to our current house. if we dont pick the house
## we can pick the previous house. now we have these two cases and we need to see which is the maximum of these and return it. 
class solution:
    def rob(self, nums):
        dp = [0]*(len(nums)+1)
        dp[1]= max(nums[0]+0 , 0)

        for i in range(2, len(nums)+1):
            dp[i] = max(nums[i-1]+dp[i-2], dp[i-1])
        return dp[-1]


    def rob_single(self, nums):

        prev = 0
        cur = max(0 + nums[0], prev)

        for i in range(1,len(nums)):
            temp = cur
            cur = max(prev+nums[i], cur )
            prev=temp
        
        return cur
