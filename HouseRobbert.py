"""
The approach here is to keep on computing the the current index + the index - 2 values sum and the 
index - 1 sums and compare them for max values which ever is maximum store that in the dp array.

"""

def rob(self, nums):
        if len(nums)==0:
            return 0
        if len(nums)==1:
            return nums[0]
        dp = [0]*len(nums) 
        dp[0], dp[1] = nums[0], max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            dp[i] = max(dp[i-2]+nums[i], dp[i-1])
        print(dp)
        
        return max(dp)