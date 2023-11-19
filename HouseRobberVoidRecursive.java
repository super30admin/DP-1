public class HouseRobberVoidRecursive {
    int max = 0;
    //Recursive approach
    public int rob(int[] nums) {

        helper(nums, 0, 0);
        return max;
    }

    private void helper(int[] nums, int i, int cost) {
        //base
        if(i >= nums.length){
            max = Math.max(max ,cost);
            return;
        }
        //logic
        //not choosing
        helper(nums, i+1, cost);

        //choose
        helper(nums, i+2, cost+ nums[i]);
    }
}
