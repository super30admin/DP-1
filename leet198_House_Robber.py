
# Solution

# // Time Complexity : Most optimized - O(N) since we iterate over array/list once
#                      Exhaustive - O(2^n) since we look into all possible options, for each element we check what happens if we
#                      choose and not choose, so at each level number of options double
# // Space Complexity : Most optimized - O(1), we just use two variables
#                       Most optimized with array - O(N), we use an array to hold previous values
#                       Exhaustive - O(2^n) implicit stack for the recursion part
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Exhaustive Approach - For each house we have choose and not choose option, we explore both options and keep recursing till
#                       we reach the last house
# Optimized Approach - We do almost the same as exhaustive, but we use array/two variables to save the max amount robbed in the
#                      previous houses, now we decide if we get max when we rob this house and not rob the previous
#                      immediate house or we miss this house and rob the previous immediate house. When we reach last house we
#                      will have the maximum amount

def rob(nums):
    # We can further optimize on space since we only need previous two results, so we can use two
    # variables instead of list
    numLen = len(nums)
    if numLen == 0:
        return 0
    elif numLen == 1:
        return nums[0]

    prevAmount = nums[0]
    curAmount = max(prevAmount,nums[1])

    for i in range(2,numLen):
        temp = curAmount
        curAmount = max(curAmount,nums[i]+prevAmount)
        prevAmount = temp
    return curAmount
    # Using an Array to save some of the iterations results so that in exhaustive solution
    # we will be able to avoid some flows and improve performance
    # numLen = len(nums)
    # if numLen == 0:
    #     return 0
    # elif numLen == 1:
    #     return nums[0]

    # result = []

    # result.append(nums[0])
    # result.append(max(result[0],nums[1]))

    # for i in range(2,numLen):
    #     result.append(max(result[i-1],nums[i]+result[i-2]))        
    # return result[-1]

    # Exhaustive solution which gives time limit exceeded, 2^n
    # def helper(nums,idx,amountRobbed):
    #     if idx >= len(nums):
    #         return amountRobbed
    #     return max(helper(nums,idx+2,amountRobbed+nums[idx]),helper(nums,idx+1,amountRobbed))

    # return helper(nums,0,0)

if __name__ == "__main__":
    nums = [1,2,3,1]
    print(rob(nums))