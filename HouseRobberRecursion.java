// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode : No (Time Limit Exceeded Error)
// Any problem you faced while coding this : No

// Notes : Brute force solution involves calculating max from the sum of element at current(i) and i+2 position and sum of element at current(i) and i+3 position iteratively. 

public class HouseRobberRecursion {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        if(nums.length == 1) return nums[0];
        
        return Math.max(calculate(nums, nums[0], 0), calculate(nums, nums[1], 1));
    }
    
    private int calculate(int[] nums, int sum, int i){
        
        int case1 = sum;
        int case2 = sum;    
        
        if(i+2 < nums.length){
            case1 = calculate(nums, sum + nums[i+2], i+2);
        } 
        if(i+3 < nums.length){
            case2 = calculate(nums, sum + nums[i+3], i+3);
        }
          
        return Math.max(case1, case2);
    }
}
