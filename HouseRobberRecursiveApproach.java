class HouseRobberRecursiveApproach {
//Recursive appraoch to check each and every possibility exhaustively.
    //TC is exponential and time limit will exceed and will not pass all test cases.

    public int rob(int[] nums) {
        if(nums==null || nums.length==0){       //base condn to check if nums is empty
            return 0;
        }

        return recurse(nums,0,0);           //Return recursive fxn with nums array, current index=0 and earings =0 i.e the robbed amount.
    }


    private int recurse(int nums[], int index, int earnings){
        //base condn
        if(index>=nums.length){
            return earnings;
        }

        //When not choose i.e 0 case
        int case1= recurse(nums, index+1, earnings); //index will be +1 as not choosing that house & there will be no earnings.

        int case2= recurse(nums, index+2, nums[index]+earnings); //index will increment by 2 as choosing that house and can not rob adjacent house and earing will also increase.


        return Math.max(case1, case2);
    }



    public static void main(String[] args){
        HouseRobberRecursiveApproach obj=new HouseRobberRecursiveApproach();
        int[] nums={1,2,3,1};
        System.out.println(obj.rob(nums));
    }
}