// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach: We try the repeated subproblems approach where we build a dp array.
// dp[n] would have the maximum robbings

class Solution {
    public int rob(int[] nums) {
       
        //edge cases
        if(nums.length==0 || nums==null) return 0;
        if(nums.length==1) return nums[0];
        
        int n=nums.length;
    
        int[] dp=new int[n];
        
        // fill the first 2 rows
        int prev=nums[0]; //2 step back
        int curr=Math.max(nums[0],nums[1]); // 1 step back
        
        for(int i=2;i<n;i++){
            int temp=curr; //old curr
            curr=Math.max(curr,nums[i]+prev); // new curr
            prev=temp; //old curr is now prev        
        }      
        return curr;     
    }   
}