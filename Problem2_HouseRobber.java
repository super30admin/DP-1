// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


// Your code here along with comments explaining your approach
/*
We check the choose/No choose a house to rob

Will maintain the result array
If first we want to rob the house then we will add the cost with cost house before previous house
Otherwise simply assign the cost of previous robbed house
*/

class Solution {
    public int rob(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        
        
        int n = nums.length;
        int result[] = new int[n];
        
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i< n; i++){
            result[i] = Math.max(result[i-1], nums[i] + result[i-2]);
        }
        
        
        return result[n-1];
    }
}




/*
// --> Brute-Froce solution

public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        return calculate(nums, 0, 0);
}
    
public int calculate(int[] nums, int index, int maxSum){
        
        if(index >= nums.length)  return maxSum;
        
           
        int robHouse = calculate(nums, index + 2, maxSum + nums[index]);
        
        int noRobHouse = calculate(nums, index + 1, maxSum);
        
        return Math.max(robHouse, noRobHouse);
}


*/