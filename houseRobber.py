"""
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is 
that adjacent houses have security systems connected and it will automatically contact the police if two adjacent 
houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

"""
"""
Solution:
    Brute force: recurssion
    write a recursion -> if house is choosen and house is not choosen, get the max value out of both the cases
    if the current house is choosen, increase the index by 2 and add current house value to summ
    if the current house is not choose, increase the index by 1 and remain the summ as same
    def rob(nums: List[int]) -> int:
        if(nums == None or len(nums)==0):
            return 0
        
        return helper(nums, 0, 0)
    
    def helper(nums, index, summ):
        
        if(index>=len(nums)):
            return summ
        
        case1 = helper(nums, index+2, summ+nums[index])
        
        case2 = helper(nums, index+1, summ)
        
        return max(case1, case2)

    Dynamic approach
    maintain two sums 
        1st: if current house is not choosen -> In that case sum will be maximum value of previous house
        2nd: if current house is choosen -> sum = value if previous house is not choosen + current house value

        return the maximum of the two values of the last house
"""


def rob(nums):
    if(nums == None or len(nums)==0):
        return 0
    dpArray = []
    dpArray.append([0, nums[0]])
    for i in range(1, len(nums)):
        dpArray.append([max(dpArray[i-1][0], dpArray[i-1][1]), dpArray[i-1][0]+nums[i]])
        
    return max(dpArray[-1][0], dpArray[-1][1])

print(rob([1,2,3,1]))