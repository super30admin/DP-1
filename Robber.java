// top down TC O(nums.length)
//to down SC O(nums.length)
// bottom up TC O(nums.length)
//bottom up  SC O(nums.length)
//runs in leetcode
class Robber {
    static int [] dp;
    public static int rob(int[] nums) {
        dp = new int[nums.length];
        //since house can contain 0 we need to intitiaze with non zero
        Arrays.fill(dp, -1);
        return rob(nums, 0);
    }
    // this is top down approach of memoized recursion
    private static int rob(int[] nums, int index){

        //invalid condition
        if(index >= nums.length){
            return 0;  //if no house left money should be 0
        }

        if(dp[index] == -1){

            int sel = rob(nums, index+2);

            sel = sel + nums[index];

            int notSel = rob(nums, index+1);
            dp[index] = Math.max(sel, notSel);
        }
        return dp[index];
    }
   // this is bottom up approach
    public static int robBottomUp(int[] nums) {
        int [] dp = new int[nums.length];

        for(int i=0; i< nums.length; i++){
            int tmpSel=0, tmpNotSel=0;

            if(i-2 < 0)
                tmpSel =0;
            else tmpSel = dp[i-2];

            if(i-1 < 0)
                tmpNotSel=0;
            else tmpNotSel= dp[i-1];

            int sel = nums[i] + tmpSel;
            int notSel = tmpNotSel;

            dp[i] = Math.max(sel,notSel);

        }

        return dp[nums.length-1];
    }

    public static final void main(String [] args){

        int [] nums = {2,7,9,3,1};
        System.out.println("output:: " + rob(nums));
        System.out.println("output bottom up:: " + robBottomUp(nums));

    }
}