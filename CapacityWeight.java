// "static void main" must be defined in a public class.
public class CapacityWeight {
    public int find(int[] w,int[] value,int cw){
        if(w==null || w.length==0 || value==null || value.length==0){
            return 0;
        }

        int[][] dp= new int[w.length+1][cw+1];
        for(int j=0; j<cw+1;j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<w.length+1;i++){
            for(int j=0; j<cw+1;j++){
                if(j<w[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=value[i-1]+dp[i][j-w[i-1]];
                }
            }
        }
        return dp[w.length][cw];

    }
    public static void main(String[] args) {
        int[] w= {1,2,3};
        int[] value={60,100,120};
        int cw=5;
        CapacityWeight obj=new CapacityWeight();
        System.out.println(obj.find(w,value,cw));
    }
}