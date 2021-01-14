/**
Leet Code Submitted : NA (Since,its a recursion based solution and will cause Time Limit Exceeded Error)
Space Complexity : O(2^N)
Time Complexity : O(2^N)
The idea is to recursive try all the sub-problems in decision tree. The decision will be to rob the particular house or not**/

class Solution {
    public int rob(int[] nums) {
        
        int max = 0;
        if(nums == null || nums.length < 1)
            return max;
        return decision(nums,0,max) ; 
    }
    
    int decision(int[] nums,int i,int max){
        if(i >= nums.length)
            return max;
    
        return (Math.max(decision(nums,i+2,max+nums[i]),decision(nums,i+1,max)));
        
    }
}