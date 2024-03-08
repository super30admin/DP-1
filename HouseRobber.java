//tc = o(n)
//sc = o(n)

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        if(nums.length == 1){ // important test case
            return nums[0]; 
        }
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0],nums[1]); //important test case
        for(int i=2;i<result.length;i++){
            result[i] = Math.max(nums[i] + result[i-2],result[i-1]);
        }
        return result[nums.length-1];
    }
}