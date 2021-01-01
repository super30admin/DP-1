# Approach: We want to find the max sums at every iteration without the adjacent elements
# Base Cases:
# If length of nums is empty --> return 0
# If length is 1, that will be the maximum sum, we assign a new array and update its indices with the following
# Otherwise at every i, the max will be max(i, i-1, i-2 + i)
# Time Complexity: O(N)
# Space Complexity: O(N)
# Successfully ran on leetcode

def house_reobber(nums):
    if len(nums) == 0:
        return 0
    
    if len(nums) == 1:
        return nums[0]
    
    maxSum = nums[:]
    maxSum[1] = max(nums[0], nums[1])
    for i in range(2, len(nums)):
        maxSum[i] = max(maxSum[i-1], maxSum[i-2] + maxSum[i], maxSum[i])
        
    return maxSum[-1]