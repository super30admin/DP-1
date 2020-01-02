package Day8;

//Time Complexity = O(n) Space Complexity: O(1)

public class RobberDP2 {

    public int rob(int[] nums){
        //Edge
        if(nums == null || nums.length == 0) return 0;

        int chosen = 0;
        int notChosen = 0;

        for(int i = 0; i < nums.length; i++){
            int temp = chosen;
            chosen = notChosen + nums[i];
            notChosen = Math.max(temp, notChosen);
        }
        return Math.max(chosen, notChosen);
    }


    public static void main(String args[]){
        RobberDP1 ob = new RobberDP1();

        int nums[] = new int[]{1,2,3,1};

        System.out.println("Max amount that can be robbed: "+ ob.rob(nums));
    }
}
