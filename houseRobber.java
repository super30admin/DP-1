// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int rob(int[] nums) {
        if(nums.length==0 || nums==null) return 0;
        int[][] matrix = new int[nums.length][2];
        matrix[0][0] = 0;
        matrix[0][1] = nums[0];
        for(int i=1;i<nums.length;++i)
        {
                matrix[i][0] = Math.max(matrix[i-1][1],matrix[i-1][0]);
                matrix[i][1] = matrix[i-1][0] + nums[i];
        }
        return Math.max(matrix[nums.length-1][0],matrix[nums.length-1][1]);
        
    }
}