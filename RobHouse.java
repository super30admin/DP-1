// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/*
Algorithm:
==========
1. As robber can steal only from alternate houses, we need to keep track of 2 sums, prev and current. 
2. If currentSum is smaller than prevSum+newHouse money, implies currentSum has to be updated. 
3. Old currsum would be new prevSum in that case. 
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