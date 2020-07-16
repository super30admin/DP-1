//Time Complexity : O(n)
// Space Complexity : O(1)
// Did it run on leetcode :yes



class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        
        int max1 = nums[0];
        int max2 = Math.max(nums[0] , nums[1]);
        
        int temp =0; 
       
        for(int i = 2 ; i < nums.length; i++){
            max1 = Math.max(max2, max1+nums[i]);
            temp =max2;
            max2 = max1;
            max1 = temp;
               
                
        }
        return max2;
        
    }
}