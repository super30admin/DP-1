package Day8;
//Time Complexity: O(2^n) Exponential complexity
//Because of recursion you will end going "Time Limit Exceeded" though not for this case
public class RobberRec {
    public int rob(int[] nums){
        return helper(nums,0,0);
    }

    private int helper(int[] nums, int i, int sum){
        //Base Case
        if(i >= nums.length) return sum;

        //Logic
        //Choose an index
        int case1 = helper(nums, i+2, sum + nums[i]);
        //Not choose an index
        int case2 = helper(nums, i+1, sum);

        return Math.max(case1, case2);
    }

    public static void main(String args[]){
        RobberRec ob = new RobberRec();

        int nums[] = new int[]{1,2,3,1};

        System.out.println("Max amount that can be robbed: "+ ob.rob(nums));
    }
}
