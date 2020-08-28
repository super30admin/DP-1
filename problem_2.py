# Time : O(n)

def rob(self, nums):
    if len(nums) == 0:
        return 0
    if len(nums) == 1:
        return nums[0]
        
    # in this approach we maintian 
    # a dp array of size nums. 
    # We iterate in a reverse order.
    # We keep track of max value that signifies
    # the maximum reward in the array starting 
    # from the house next to the next house. 
    dp = [-1]*len(nums)
    max_val = nums[-1]

    dp[-1] = nums[-1]
    dp[-2] = nums[-2]
        
    for i in range(len(nums)-3, -1, -1):
        dp[i] = nums[i] + max_val
        max_val = max(max_val, dp[i+1])
        
    return max(dp[0], dp[1])