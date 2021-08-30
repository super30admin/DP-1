// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        // two variables skip for not choosing that house, and take for choosing that house
        // intially. choosing house take will be nums[that house]=nums[0] and not taking will be 0
        int skip=0;
        int take=nums[0];
        //for storing previous skip value
        int temp =0;
        for(int i=1;i<nums.length;i++){
            temp = skip;
            //skip i.e., not choosing that particular house chances will be max of prev row choosing and not choosing cause if we skip the house at current index we may or maynot take house from previous index.
            skip = Math.max(temp,take);
            //take i.e., choosing that particular house chances will nums[current index house] + previous row skip cause if we take the house at current index we should not take house from previous index ie., prev index skip value.
            take = nums[i]+ temp;
        }
        //return max of skip and take
        return Math.max(skip,take);
    }
}