// Time Complexity:  O(n)
// Space Complexity: O(n)

class Solution {
    public int rob(int[] nums) {
        
        int[] matrix = new int[nums.length];
        
        if(nums.length == 1) return nums[0];
        
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        
        matrix[0] = nums[0];
        matrix[1] = Math.max(nums[0],nums[1]);
        
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        
        for(int i=2; i<nums.length; i++){
            matrix[i] = Math.max(nums[i] + matrix[i-2], matrix[i-1]);
        }
        
        return matrix[nums.length-1];
    }
}