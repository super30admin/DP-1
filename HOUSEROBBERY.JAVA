// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
//Appproach:// Using dp to track the max amount robbed without robbing adjacent houses
// At each step, choose between skipping the current house or robbing it and adding value from two houses back
// Return the final value as the maximum money that can be robbed safely
class Solution {
    public int rob(int[] nums) {
     if(nums==null || nums.length ==0  ){
        return 0;
     }   
     if ( nums.length==1){
        return nums[0];
     }
     int prev= nums[0];
     int curr= Math.max(nums[0], nums[1]);

     for(int i=2;i<nums.length;i++){
        int temp=rob;
        curr=Math.max(temp,prev+nums[i]);
        prev=temp;
     }
     return curr;
    }
}