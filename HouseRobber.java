// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are iterating through the original array
//Space Complexity: O(1) since we are just using variables and not any extra dp array 

public int rob(int[] nums) {
        
        if(nums==null || nums.length == 0) return 0;
        
        int skip = 0;
        int take = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp = skip;
            // The amount for not choosing part of the next house will be equal to the Max amount of previous skip and take
            skip = Math.max(skip,take);
            take= nums[i]+ temp;
        }
        return Math.max(skip,take);
    }