//TC: O(n)
//SC: O(1)

class HouseRobber{

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int amount[] = new int[nums.length];

        amount[0] = nums[0];
        if (nums.length == 1){
            return amount[0];
        }
        //though process
        // as we can get amount from any index other than one index less, so we have
        //to compare first two houses to determine the path.
        amount[1] = Math.max(amount[0],nums[1]);

        for (int i = 2; i < nums.length; i++){
            amount[i] = Math.max(amount[i-2] + nums[i],amount[i-1]);
        }

        return amount[nums.length-1];
    }
}