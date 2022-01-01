// Time Complexity : o(n)
// Space Complexity :n as nums.length o(n)
// Did this code successfully run on Leetcode :Yes


/* taking new array to store maximum amount we can store at particular point/index */
class Solution {
    public int rob(int[] nums) {
      int[] array = new int [nums.length];      // creadted new array 
        if(nums.length==1){
            return nums[0];
        }
        array[0]=nums[0];
        array[1]= Integer.max(nums[0],nums[1]);
        
        for(int i=2;i<=nums.length-1;i++){
             array[i]=Integer.max(array[i-1],(nums[i]+array[i-2]));
        }
        return array[array.length-1]; 
    } 
}
