public class rough {
    public int solve(int [][] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        for(int i = A.length - 2; i >= 0; i--) {
            A[i][0] = A[i][0] + Math.min(A[i + 1][1], A[i + 1][2]);
            A[i][1] = A[i][1] + Math.min(A[i + 1][0], A[i + 1][2]);
            A[i][2] = A[i][2] + Math.min(A[i + 1][1], A[i + 1][0]);
        }
        return Math.min(A[0][0], Math.min(A[0][1], A[0][2]));
    }
}
