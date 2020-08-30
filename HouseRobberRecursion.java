public class HouseRobberRecursion {
    
    public int rob(int[] nums) {
   
        return robRec(nums,0);

    }
    public int robRec(int nums[], int idx){

        if(nums.length == 0) return 0;

        if(idx >= nums.length) return 0;

        int robYes = nums[idx] + robRec(nums, idx + 2);
        int robNo = robRec(nums, idx + 1);

        return Math.max(robNo, robYes);
    }    


    public static void main(String args[]) {
        HouseRobberRecursion obj = new HouseRobberRecursion();
        int[] nums = { 3, 2, 3, 8 };

        System.out.println("Maximum amount robbed = " + obj.rob(nums));
    }
}