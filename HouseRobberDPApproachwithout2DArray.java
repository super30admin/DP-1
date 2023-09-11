
    class HouseRobberDPApproachwithout2DArray {
        //Using DP and without 2D array and updating the value in 2 variables.
        // TC will be O(N), as traversing only once.
        //SC will O(N), as array is of N*2 and ignoring 2.
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {       //Base condn to check array is not empty
                return 0;
            }
            int skip = 0;
            int take = nums[0];

            for (int i = 1; i < nums.length; i++) {           //To traverse over N houses
                int temp = skip;             //Variable to store current val of skip
                skip = Math.max(skip, take);      //Update the value of skip
                take = temp + nums[i];             //if choose
            }
            return Math.max(skip, take);     //return the max value
        }

        public static void main(String[] args) {
            HouseRobberDPApproachwithout2DArray obj = new HouseRobberDPApproachwithout2DArray();
            int[] nums = {1, 2, 3, 1};
            System.out.println(obj.rob(nums));
        }
    }