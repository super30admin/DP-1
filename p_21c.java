// Time Complexity :o(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approachclass Solution {
    public int rob(int[] nums) {
        if(nums == null) return 0;
        //int [][] dp = new int [nums.length][2];
        int skip = 0;
        int take = nums[0];
        for(int i  = 1; i < nums.length; i++){
            int temp = skip;// storing prev_skip in temp as skip get overwritten in step below 
            //skip
            skip = Math.max(skip,take); //prev_skip,preV_take
            //take
            take = temp + nums[i];//prev_skip is temp as skip gets over return in step above + curr_take_value
        }
            return Math.max(skip,take);
    }
}