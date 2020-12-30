// Time Complexity : O(n) n: number of houses
// Space Complexity : O(n) n: number of houses
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// either rob  a house or its neighbour. if you decide to rob a house, leave one house and try same algo again.
// to maximize amount, choose max between a house amount with max possible with the remaining houses and its neighbour amount with max possible with remaing house.
// Save max till that house to avoid same computation multiple times.

//Top Down
public int rob(int[] nums) {
    if(nums.length == 0) return 0;
    int[] amount = new int[nums.length];
    for(int i = 0; i< amount.length; i++){
        amount[i] = -1;
    }
    return helper(nums, amount, 0);
}
public int helper(int[] nums,int[] amount, int i){
    if(i>=nums.length) return 0;
    if(i==nums.length-1) return nums[i];
    if(i == nums.length-2) return Math.max(nums[i], nums[i+1]);
    if(amount[i] >= 0) return amount[i];
    int a = Math.max(helper(nums,amount,i+2) +nums[i], helper(nums, amount, i+3) +nums[i+1]);
    if(a>amount[i]) amount[i] = a;
    return amount[i];
}  
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// max amount for a house will be its amount plus max of previous two houses.

//Bottom Up
public int rob(int[] nums) {
    int n = nums.length;
    if(n == 0) return 0;
    if(n == 1) return nums[0];
    if(n == 2) return Math.max(nums[0],nums[1]);
    int[] amount = new int[n];
    amount[0] = nums[0];
    amount[1] = nums[1];
    amount[2] = nums[2] + nums[0];
    for(int i = 3; i< n;i++){
        amount[i] = Math.max(amount[i-2],amount[i-3]) + nums[i];
    }
    return Math.max(amount[n-1],amount[n-2]);
}