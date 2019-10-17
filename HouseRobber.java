/*
Author: Akhilesh Borgaonkar
Problem: LC 198. House Robber (DP-1)
Approach: Iterating through the input array and checking the maximum of (previous sum + current element) and (previous sum). This will give me the 
    maximum amount and guarantee that no two continuous elements are added to avoid alarm.
Time Complexity: O(n) where n is number of elements in array.
Space complexity: O(1) constant. (not sure about this)
LC Verified.
*/

class Solution {
    public int rob(int[] nums) {
        int prevSum = 0, currSum = 0;
        for(int i=0 ; i<nums.length; i++){
            int tmp = currSum;                      //saving previous sum
            if( (prevSum+nums[i]) > currSum )       //checking if the new sum by adding current element is greater than previous sum
                currSum = prevSum+nums[i];          //if greater then add that element to final sum
            prevSum = tmp;                          //make current sum as previous for next iteration
        }
        
        return currSum;
    }
}