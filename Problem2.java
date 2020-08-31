// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// if Don't choose take the max from above element 
// if chosen the value : take the current value + DC value of previous element
// return max of c and dc
class Solution {
    public int rob(int[] nums) {        
        if(nums == null || nums.length ==0)
            return 0;
        
        int c=0,dc = 0;
        
        for(int i = 0; i<nums.length ; i++){
            int temp = dc;
            
            dc = Math.max(c,dc);
            
            c = nums[i] + temp;
        }
    
        return Math.max(c,dc);
            
    }
}