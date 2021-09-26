// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : initially faced lot of bounds error.


// Your code here along with comments explaining your approach:- initially same size of nums array is taken in which first element is same as nums array and second element is max of first element ,second element of nums and then filling from third using dp.

class Solution {
    public int rob(int[] nums) {
        int[] a=new int[nums.length];
        
        if(nums.length==1){
            return nums[0];
        }
        else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        else{
            a[0]=nums[0];
            a[1]=Math.max(nums[0],nums[1]);
        
            for(int i=2;i<nums.length;i++){
                a[i]=Math.max((nums[i]+a[i-2]),a[i-1]);
            }
            
            
        

}
return a[nums.length-1];}
}