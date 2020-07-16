//Brute force
//Time Complexity : O(2^n))
//Space Complexity : Just the stack space
// Run succesfully on leetcode (Time exceeded)
// Problems :  No problem

//Optimized DP
//Time Complexity : O(n)
//Space Complexity: O(1)
//Run successfully on leetcode
//Problem : No problem



public class DP_1_Problem_2 {

    public int robz(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return helper(nums,0,0);

    }
    private int helper(int[] nums,int index,int collection)
    {
        if(index>= nums.length) return collection;

        int case1 = helper(nums,index+1,collection);
        int case2 = helper(nums,index+2,collection + nums[index]);
        return Math.max(case1,case2);

    }



    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int choose=0;
        int notChoose=0;
        for(int i=0;i<nums.length;i++)
        {
            int max = Math.max(choose,notChoose);
            choose = notChoose + nums[i];
            notChoose = max;
        }
        return Math.max(choose,notChoose);

    }

}
