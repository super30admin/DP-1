// Time Complexity : O(N)
// Space Complexity : O(2N) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this: understood
// Summary: //In this problem we are creating a 2 column matrix of taking or skipping the house
            //skip condition takes max from row above
            //take condition adds the value in array to the skip of row above

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int skip = 0;
        int take = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp = skip;
            //0
            skip = Math.max(skip,take);
            //1
            take = temp + nums[i];
            ///System.out.println("Skip: " + skip + " " + "Take: " + take);
        }
        return Math.max(skip, take);
    }
}