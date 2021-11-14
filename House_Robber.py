""" 
 Time Complexity : O(n)
 Space Complexity : O(1)
 Did this code successfully run on Leetcode : yes
 Any problem you faced while coding this : No


 Your code here along with comments explaining your approach   """

def HouseRobber(nums) -> int:
    dp = [0, nums[0], nums[0]]

    for i in range(1,len(nums)):
        dp[0], dp[1] = max(dp[1], dp[2]), dp[2] + nums[i]
        dp[2] = dp[0]
    return max(dp)

    
"""def helper(nums, count) -> int:
    #base
    if len(nums) <= 0:
        return count
    #recursive logic

    #Choose case
    case1 = helper(nums[2:], count + nums[0])

    #Not Choose case

    case2 = helper(nums[1:], count)

    return max(case1,case2) """

output = HouseRobber([2,7,9,3,1])

print(output)

