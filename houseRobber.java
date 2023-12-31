//TC O(2 pow n)
//SC O(1)

class houseRobber {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int re=helper(nums,0,0);
        return re;
    }
    public int helper(int[] nums,int idx,int sum){

        //base case
        if(idx>=nums.length)
            return sum;
        //choose
        int case1=helper(nums,idx+2,sum+nums[idx]);
        //not choose
        int case2=helper(nums,idx+1,sum);
        //return
        return Math.max(case1,case2);

    }
}