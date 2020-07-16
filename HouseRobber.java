// Time Complexity : O(N) n: no.of element
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int rob(int[] nums) {
        // Inititalizing PrevMax to store the max till that and currMax to get the new max for robbering
        int prevMax = 0;
        int currMax = 0;
        // Iterating over each element of nums
        for(int x : nums){
            //Storing the currMax in temp variable
            int temp = currMax;
            // Updating the currmax by checking the value of currmax with the value of prevMax + x
            currMax = Math.max(prevMax + x, currMax);
            // Updating the prevmax with the temp
            prevMax = temp;
        }
        
        return currMax;
    }
}