// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
    //None

class Solution {
    public int rob(int[] nums) {
        
        //base case
        if(nums == null || nums.length == 0){
            return 0;
        }

        int skip = 0;
        int take = nums[0];

        for(int i = 1; i < nums.length; i++){
           int tempSkip = skip;
           skip = Math.max(skip, take);
           take = tempSkip + nums[i];
        }

        //returning the maximum between skip and take
        return Math.max(skip, take);

    }
}