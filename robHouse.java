// Time Complexity :O(n*m)
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//recursive approach
public int rob(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    return helper(nums,0,0);
}
private int helper(int[] nums, int index, int robAmount){
    //base
    if(index >= nums.length){
        return robAmount;
    }
    //logic
    //do not rob case
    int case1 = helper(nums,index+1,robAmount);
    //rob case por 1 case
    int case2 = helper(nums,index+2,robAmount + nums[index]);
    
    return Math.max(case1,case2);
}

//Using dynamic Programming
public int rob(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
        //using 2 variables to implement the dynamic programming. Since we don't need to store the values, we can only use 2 variables.
        int skip=0;
        int take =nums[0]; // initializng the first row of imaginary matrix
    
    for(int i=1;i<nums.length;i++){
        int temp = skip;
        skip = Math.max(skip,take); // the case when we are not robbing the current house
        take = temp + nums[i]; // the condition when we are robbing the current house
    }
        
    return Math.max(skip,take);
}