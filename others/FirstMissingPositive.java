public class FirstMissingPositive {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        int length = A.length;
        int i = 0;
        while (i < length) {
            if (A[i] > 0 && A[i] <= length && A[i] != i + 1 && A[i] != A[A[i] - 1]) {
                swap(A, i, A[i] - 1);
            } else {
                i++;
            }
        }
        for (int j = 0; j < length; i++) {
            if (A[j] != j + 1) {
                return j + 1;
            }
        }
        return length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive test = new FirstMissingPositive();
        int[] A = {-1, 6, 7, 2, 3, 1, 4};
        System.out.println(test.firstMissingPositive(A));
    }
}
