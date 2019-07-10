// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class HouseRobber {

    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        
        int[] max_so_far = new int[nums.length];
        max_so_far[0] = nums[0];
        max_so_far[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for(int i=2;i<nums.length;i++){
            max_so_far[i] = Math.max(nums[i]+max_so_far[i-2], max_so_far[i-1]);
        }
        
        return max_so_far[nums.length-1];
    }
    public static void main(String[] args){
        System.out.println("House Robber");
        HouseRobber obj = new HouseRobber();
        int[] nums = {6,7,8,3,1,2,4};
        System.out.println(obj.rob(nums));

    }
}