// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Implemented solution explained in class

//Took 2 variables for the conditions we have at hand, to either choose the house or dont choose the house
//We keep updating them at each index , result if we choose or dont 
//return the max of the two

class Solution {
    public int rob(int[] nums) {
        
        int C=0, DC=0;
        int temp=0;
        
        
        for(int i=0;i<nums.length;i++){
            temp=DC;
            DC=Math.max(C,DC);
            C=nums[i]+temp;
            
            
        }
        return Math.max(C,DC);
    }
}