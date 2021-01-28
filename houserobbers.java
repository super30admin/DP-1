// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : understood from the class


// Your code here along with comments explaining your approach:
// As this requrires us to go through all the combinations, but only returns one value hence a DP problem.
// This approach is the second approach here where we chose or not chose 
// one house to rob depending on the consecutive house, 
//as two consecutive huse shouls not be robbed. Then Maximum is chosen because aount is to be returned.

class Solution {
    public int rob(int[] nums) {
        
        if(nums== null || nums.length==0){
            return 0;
        }
        int C=0; int DC=0; // instead of making a matrix out of this like previous problem we considered them as two variables
        for(int x:nums){
            int temp=DC;
            DC= Math.max(C,DC);
            C=x+temp;
        }
    return Math.max(C,DC);
    }
}