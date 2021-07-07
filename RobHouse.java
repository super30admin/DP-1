// Time Complexity : O(N) for both approaches where N is number of houses
// Space Complexity : O(N) for approach-1 and O(1) for approach-2
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


//================================= Approach-1 ================================================
/*
Algorithm:
==========
1. Keep track of max amount so far in an array as we iterate through the array of houses
2. Max at the last house would be the max amount a robber can get
*/

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        // array to keep track of max amount so far
        int[] amount = new int[nums.length+1];
        amount[1] = nums[0];
        for(int i = 2; i <= nums.length; i++) {
            // max of current sum and (previous sum + current value)
            amount[i] = Math.max(amount[i-1],amount[i-2]+nums[i-1]);
        }
        
        return amount[nums.length];
    }
}

//================================= Approach-2 ================================================

/*
Algorithm:
==========
1. As robber can steal only from alternate houses, we need to keep track of 2 sums, prev and current. 
2. If max is smaller than prevSum+newHouse money, implies max has to be updated. 
*/

class Solution {
    public int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        
        //Check if currMax or prevMax+currHouse is bigger and update currMax
        for(int currHouse: nums) {
            int temp = currMax;
            currMax = Math.max(prevMax+currHouse,currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
