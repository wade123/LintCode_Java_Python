public class JumpGame {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
//Greedy
    public boolean canJump(int[] A) {
        int reach = 0;
        for (int i = 0; i < A.length; i++) {
            if (reach < i) {
                return false;
            }
            reach = Math.max(reach, i + A[i]);
            if (reach >= A.length - 1) {
                return true;
            }
        }
        return false;
    }

//Dynamic Programming
    public boolean canJump(int[] A) {
        boolean[] f = new boolean[A.length];
        f[0] = true;
        for (int i = 1; i < A.length; i++){
            for (int j = 0; j < i; j++){
                if (f[j] && j + A[j] >= i){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[A.length - 1];
    }

    public static void main(String[] args) {
        JumpGame test = new JumpGame();
        int[] A = {3,2,1,0,4};
        System.out.println(test.canJump(A));
    }
}