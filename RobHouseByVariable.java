// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class CoinChangeWithDPMatrix {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        
        if(nums.length ==1)
            return nums[0];
        
        int choose = nums[0];
        int skip = 0;
        
        for(int i =1; i < nums.length; i++) {
            int prevSkip = skip;
            skip = Math.max(skip, choose);
            choose = prevSkip + nums[i];
        }
        
        return Math.max(skip, choose);
    }
}
