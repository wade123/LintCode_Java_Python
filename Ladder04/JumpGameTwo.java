public class JumpGameTwo {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
//dp
    public int jump(int[] A) {
        int[] f = new int[A.length];
        f[0] = 0;
        for (int i = 1; i < A.length; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + A[j] >= i) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[A.length - 1];
    }

//Greedy
    public int jump(int[] A) {
        int lastStep = 0;
        int reach = 0;
        int step = 0;
        for (int i = 0; i < A.length; i++) {
            if (reach < i) {
                return -1;
            }
            if (i > lastStep) {
                step++;
                lastStep = reach;
            }
            reach = Math.max(reach, A[i] + i);
        }
        return step;
    }
}