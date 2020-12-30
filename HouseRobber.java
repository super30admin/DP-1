/*
//time complexity : O(n), n is the number of elements in array
//space complexity: O(n), n is the number of elements in array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : still unclear with many dp concepts

*/

class HouseRobber {
    //method 1: brute force approach to find all possible alternating numbers in array and find max sum
    //O(n^3)
    
    
    //method 2: to use a array to maintain the max sum previously calculated 
    
    public int rob(int[] nums) {
        
        if(nums.length == 0){
            return 0;
        }
        
        //if there is only one house then return that house amount
        if(nums.length == 1){
            return nums[0];
        }
        
        int[]dp = new int[nums.length];
        //dp array will save the  amount that can be robbed
        
        dp[0] = nums[0]; // 0th index will have nums[0]
        dp[1] = Math.max(nums[0],nums[1]);//1st index will have max of 0th and 1st index of nums array 
        //as we going to choose maximum amount 
        
        
        
        //for each house starting at index 2
        // include will have the previous to previous sum calcualted in dp and current element
        //exclude will have only prevous calculted sum
        //dp[i] will be max of include and exclude
        
        for(int i = 2;i < nums.length;i++){
            int include = dp[i-2] + nums[i];
            int exclude = dp[i-1];
            dp[i] = Math.max(include , exclude);
            
            
        }
        
        return dp[nums.length-1];
    }
}
