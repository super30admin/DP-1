# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : I am not sure if this is the best approach


# // Your code here along with comments explaining your approach
def rob(nums):
    len_nums = len(nums)
    if len_nums == 1: return nums[0]
    x = [0]*len_nums
    x[0]= nums[0]
    x[1] = max(nums[0], nums[1])
    for i in range(2, len_nums):
        x[i] = max(x[i-2]+nums[i], x[i-1])
    return x[-1]
