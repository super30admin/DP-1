# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# exhaustive approach - TC O(2^n)
# def rob(nums):
#     if nums == None or len(nums) == 0:
#         return 0
#     return helper(nums,0,0)

# def helper(nums,i,amount):
#     if i >= len(nums):
#         return amount
    
#     case1 = helper(nums,i+2,amount+nums[i])

#     case0 = helper(nums,i+1,amount)

#     return max(case1,case0)



def rob(nums):
    if len(nums) == 0:
        return 0
    if len(nums) == 1:
        return nums[0]
    dp_nums = [0] * len(nums)
    dp_nums[0] = nums[0]
    dp_nums[1] = max(nums[0], nums[1])
    for i in range(2, len(nums)):
        dp_nums[i] = max(dp_nums[i - 1], dp_nums[i - 2] + nums[i])

    return dp_nums[-1]






# def rob(nums):
#     rob1, rob2 = 0, 0
#     for n in nums:
#         temp = max(n+rob1,rob2)
#         rob1 = rob2
#         rob2 = temp
#     return rob2

nums = [6,9,8,1,1,5]
print(rob(nums))