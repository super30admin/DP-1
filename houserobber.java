//TC - O(n)
//SC -O(n)

class Solution {
    public int rob(int[] nums) {
        int [] memo = new int[nums.length+1];
        Arrays.fill(memo,-1);
        return house(nums,0,memo);
    }
    public int house(int[]nums,int currIndex,int[]memo){
        
        if(currIndex==nums.length-1) return nums[currIndex];
        
        if(currIndex>=nums.length) return 0;
        
        if(memo[currIndex]!=-1) return memo[currIndex];
        
        int yes = nums[currIndex] + house(nums,currIndex+2,memo);
        int no = house(nums,currIndex+1,memo);
        
        memo[currIndex] = Math.max(yes,no);
        
        return memo[currIndex];
        
        
    }
}