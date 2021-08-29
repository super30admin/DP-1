// Time Complexity :O(n) n is number of houses (not sure about the Time complexity)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : ran but for a few cases Exceeded time limit
// Any problem you faced while coding this : figuring out the better solution 


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        
        int money = 0;
        money = helper(nums,0,money);
        
        return money;
    }
    
    private int helper(int[] nums,int index, int money)
    {
        //base i.e terminating point
        if(index >=nums.length )
            return money;
        
        //logic starts here
        
       // case 1 not to choose to rob
        int case1 = helper(nums , index+1,money );
            
      //  case 2 choose to rob
       int case2 = helper(nums , index+2,money + nums[index] );
        
        return Math.max(case1,case2);
    }
}