public class Heapify {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        int start = (A.length - 1 - 1) / 2;
        //start with last internal node, last node n-1,
        //so its parent is (n - 1 - 1) / 2;
        for (int i = start; i >= 0; i--) {
            shiftDown(A, i);
        }
    }

    private void shiftDown(int[] A, int index) {
        int length = A.length;
        int left = 2 * index + 1; //< length ? A[left] : Integer.MAX_VALUE;
        int right = 2 * index + 2; // < length ? A[right] : Integer.MAX_VALUE;
        while (left < length || right < length) {
            int leftValue = left < length ? A[left] : Integer.MAX_VALUE;
            int rightValue = right < length ? A[right] : Integer.MAX_VALUE;
            int next = leftValue < rightValue ? left : right;
            if (A[index] < A[next]) {
                break;
            }
            swap(A, index, next);
            index = next;
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
