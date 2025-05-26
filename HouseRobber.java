//time complexity : O(n)
//space complexity : O(n)

class HouseRobber {
    private int[] memo;
    public int rob(int[]nums) {
        this.memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return helper(nums, 0);
    }

    private int helper(int[]nums, int idx){
        if(idx >= nums.length) return 0;
        if(memo[idx] != -1) return memo[idx];
        //dont choose
        int case1 = helper(nums, idx+1);
        // choose
        int case2 = nums[idx] + helper(nums,idx+2);

        this.memo[idx] = Math.max(case1,case2);
        return Math.max(case1,case2);

    }

    public static void main(){
        HouseRobber r = HouseRobber();
        int[] nums = [1,2,3,1];
        int result = r.rob(nums);
        system.out.print("Result : " +result);

        nums = [2,7,9,3,1];
        result = r.rob(nums);
        system.out.print("Result : " +result);
    }

}
