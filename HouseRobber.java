/*
 * #198. House Robber
 * 
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 

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
 

Constraints:

0 <= nums.length <= 100
0 <= nums[i] <= 400

 */


/*
 * Time Complexity: O (N) -> traverse the array
 * 
 * Space Complexity: O (1) -> No extra space used
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.DP1;

public class HouseRobber {
	
	public int rob(int[] nums) {
        // Initialize two pointers to keep track of choose, don't choose values for a house
        int C = 0;
        int DC = 0;
        
        // Traverse through the array
        for (int i = 0; i < nums.length; i++){
        	// Since, we are going to update DC value for a current house
        	// store it first in a temp variable, because we will need DC of previous house to calculate C for current house
        	
            int temp = DC; // temp = DC value of previous house
            
            // Update the DC value for current house, since we are not choosing current house, that means we need maximum amount robbed from previous houses
            DC = Math.max(C,DC); 
            
            // If we chose current house to rob, then previous house is not robbed definitely
            // So, take DC value of previous house and add it to amount of current house
            C = temp + nums[i];
            
        }
        
        // After traversing all elements/houses, return the maximum amount robbed
        return Math.max(C,DC);
        
    }

}
