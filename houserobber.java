class Solution {
  //time exceeding solution
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        return Math.max(helper(nums,0,nums[0],0),helper(nums,1,nums[1],1));
    }
    int helper(int[] nums,int i,int amount, int robbedindex){
       int case1=-1;int case2=-1;
        if(i>=nums.length)return amount;
        
        if(robbedindex!=i && i+1<nums.length ){
         case1=helper(nums,i+1,amount+nums[i+1],i+1);
        }
            case2=helper(nums,i+1,amount,i);
        if(case1==-1)return case2;
        if(case2==-1)return case1;
        return Math.max(case1, case2);
    }
}
