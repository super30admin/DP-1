// Time Complexity :(2^n) where is the array length
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes but time limit exceeded for extreme cases
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class HouseRobber
{
    public int rob(int[] nums) {
        return helper(nums,0,0);
    }
    private int helper(int[] nums,int index,int totalAmount)
    {
        //base
        if(index>=nums.length)
            return totalAmount;
        
        //case1
        int chooseZero = helper(nums,index+1,totalAmount);
        
        //case2
        int chooseOne = helper(nums,index+2,totalAmount+nums[index]);
        
        if(chooseZero==0) return chooseOne;
        if(chooseOne==0) return chooseZero;
        
        return Math.max(chooseZero,chooseOne);
        
    }

}