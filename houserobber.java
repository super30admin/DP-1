// TC: O(n)
// SC: O(1)

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int skip=0; // do not rob
        int take = nums[0];  // rob
        
        for(int i=1;i<nums.length;i++){
            int temp = skip;  // store for take
            skip = Math.max(skip,take); 
            take = temp + nums[i];  // previous skip value + current value
        }
        
        return Math.max(skip,take);  //return maximum of the two
    }
}