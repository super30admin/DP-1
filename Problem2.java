// Time Complexity : O(nums)
// Space Complexity :O(nums)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : The logic of prev house was confusing


// Your code here along with comments explaining your approach

/*
Question states to get the max money, however, we cannot rob adjacent house.
To get max , if I rob house at index i then I should rob the house at index i+2 , as i+1 would be adjacent
We can also rephrase that to say , if I rob house at index i , then to miximize the reward I should also rob house at index i -2 

We will visit each house , and decide to rob it or not
if we decide not to rob it, then reward from prev house would be our reward
if we decide to rob it then this house reward plus the reward from houseidx -2, would give me the max reward
*/

class Solution {
    public int rob(int[] nums) {

        int[] dp = new int[nums.length]; // this would store rewards at each houses

        int  max = Integer.MIN_VALUE;
        // we will visit each index and decide what rewards we could get if we choose it vs not choose it

        for(int i=0;i<nums.length;i++){

            int choose=0;
            int notChoose = 0;
            // if we choose element at i
            // if choosen then it means we must  rob house previous to the previous house ( as we could'nt get adjacent') to get the max reward
            choose+=nums[i];
            // check if prev prev position existing
            if(isValid(nums.length,i-2)){
                choose+=dp[i -2];
            }
            // if we dont choose it , then take the reward from previous choices
            if(isValid(nums.length,i-1)){
                notChoose+=dp[i-1];
            }

            dp[i] = Math.max(choose,notChoose);

            if(max <dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }

    private boolean isValid(int length, int index){
        return (index >= 0)  && (index<length);
    }
}
