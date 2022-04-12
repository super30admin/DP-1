#coin change


# // Time Complexity : O(N) 
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

def rob( nums) :
    dp = [[0 for i in range(2)] for j in range(len(nums)+1)]
    
    for i in range(1, len(dp)):
        for j in range(2):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])                  # if you skip, your value should be max between last skip and last taken
            dp[i][1] = nums[i-1]+dp[i-1][0]                         #if you take, your value should be last skip + this taken
    return max(dp[len(nums)][0], dp[len(nums)][1])

#test
print(rob([2,7,9,3,1])) #12