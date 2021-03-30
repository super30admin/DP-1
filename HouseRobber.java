// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
                
        int a = 0; 
        int b = nums[0];
        for(int i=2;i<=nums.length;i++) {
            int temp = Math.max(b, nums[i-1] + a);
            a= b;
            b= temp;
        }
        
        return b;
    }
}