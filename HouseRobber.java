/**
Leetccode Problem 198: House Robber Pattern

You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you 
from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.


Time Complexity : O(N)
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
        
Collabedit: http://collabedit.com/habf8     
------------------------

call helper(nums, 0, 0);
create a helper function having the nums arrays and the current index we have to decide to choose or not, amount


// base case
if(index >= nums.length) return amount;

// we choose the coin on that index
int case1 = helper(nums, index + 2, amount + nums[index]);


// we decide not to choose that index
int case2 = helper(nums, index + 1, amount );

return Math.max(case1, case2);
------------------------

The above solution will give the time limit exceeded, it has the exponential time complexity


        0   1
2       0   2
7       2   0 + 7
9       7   2 + 9
8       11  7 + 8
1       15  11 + 1

Dynamic Programming solution for House Robber problem
**/

class Solution 
{
    public int rob(int[] nums)
    {
    
        if( nums == null || nums.length == 0) return 0;
        
        //  thig get initialised to 0
        int matrix[][] = new int[nums.length][2];
        
        matrix[0][1] = nums[0];
        
        for(int i =1; i< nums.length; i++)
        {
            //in this scenario, we decide to select the ith coin
            matrix[i][0] = Math.max( matrix[i-1][0], matrix[i-1][1] );
            
            // in this scenario we decide to select the ith coin
            matrix[i][1] = matrix[i-1][0] + nums[i];
        
        }
        
        
        return Math.max( matrix[nums.length -1][0], matrix[nums.length -1][1]);
        
    
        
    }
}








