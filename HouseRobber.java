/* 
   House Robber
   Time Complexity : O(N), where N = length of the array
   Space Complexity : O(1)
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
   Method: DP
*/
class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int dontrob= 0, rob = nums[0], temp =0; //initialize rob and dontrob variables
        for(int i=1;i<nums.length;i++){
           temp=dontrob;
            dontrob = Math.max(dontrob,rob); //Max of dontrob and rob variables
            rob = temp + nums[i]; 
        }
        return Math.max(rob,dontrob);
    }
}