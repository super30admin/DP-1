/*
Author: Akhilesh Borgaonkar
Problem: LC 198. House Robber (DP-1)
Approach: Using Dynamic programming approach to find the pattern of repeating sub-problems. Further optimized it by using just 2 variables to store
    previous problem results.
Time Complexity: O(n) where n is number of elements in array.
Space complexity: O(1) constant.
LC Verified.
*/

class Solution {
    public int rob(int[] nums) {
        int chosen=0, notChosen=0;
        
        for(int i=0; i<nums.length; i++){               
            int temp = chosen;                  
            chosen = notChosen + nums[i];             
            notChosen = Math.max(temp, notChosen);
        }
        
        return Math.max(chosen, notChosen);
    }
}