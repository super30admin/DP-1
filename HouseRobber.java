// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class HouseRobber {
    public int rob(int[] nums) {
        
        if(nums.length==1) return nums[0];
        
        int skip = nums[0];
        int take = nums[1];
        int tmp = -1;
        
        //skip and take are essentially storing current maximum paths of not choosing and choosing a house to rob
      
        for(int i = 2; i < nums.length; i++){
            tmp = skip;
            skip = Math.max(skip,take);
            take = tmp + nums[i];
        }
        
        return Math.max(skip,take);
    }
}
