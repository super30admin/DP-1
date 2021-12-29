"""
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.


// Time Complexity : ON
// Space Complexity :O1
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

"""
class Solution(object):
    def rob(nums):

        n = len(nums)
        even = 0;
        odd = 0;
        i = 0
        for  i  in n:
            
            if(i%2 == 0):
                even += nums[i];
                even = even > odd if even else odd;
            
            else:
                odd += nums[i];
                odd = even > odd if even else odd;
            
        
        return even > odd if even else odd
    