// Time Complexity : O(n).
// Space Complexity : O(1) as I used variables
// Did this code successfully run on Leetcode : Yes
// Approach : At every index i as can't choose the adjacent house, I will have two options - maximum of i + (i+2) value or skipping i and
// considering (i+1) value and go ahead. I have implemented tabulation approach from bottom to up with this logic. It can be donw with
// arrays as well but to get O(1) in space I have used two varables.

// Your code here along with comments explaining your approach


class Solution {
    public int rob(int[] nums) {

        int value1 = 0; //extra element as in array
        int value2 = 0; //extra element as in array
        int output = 0;

        for(int i=nums.length-1;i>=0;i--){
            output = Math.max(nums[i]+value2, value1);//two options either to proceed with i or skip i.
            value2 = value1;
            value1 = output;
        }
        return output;
    }

}