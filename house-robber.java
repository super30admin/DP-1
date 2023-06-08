// Time Complexity :o(n)
// Space Complexity :  o(1) using 3 pointer approch
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n<2){
            return nums[0];
        }
        int temp = nums[0];
        int prev = nums[0];
        int next = Math.max(prev,nums[1]);
        //iterating over the array and finding the max amount that can be robbed by comparing the previous max and the current max (If we choose to rob the current house)
        for(int i = 2; i <n;i++){
            temp =  Math.max(next, nums[i]+prev);
            prev = next;
            next = temp;
        }
        return next;
    }
}