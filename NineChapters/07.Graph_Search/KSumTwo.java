import java.util.ArrayList;
import java.util.Arrays;

public class KSumTwo {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null || A.length == 0) {
            return result;
        }
        Arrays.sort(A);
        ArrayList<Integer> list = new ArrayList<Integer>();
        kSumIIHelper(A, 0, target, k, list, result);
        return result;
    }

    private void kSumIIHelper(int[] A, int index, int target, int count,
        ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
        if (target == 0 && count == 0) {
            result.add(new ArrayList<Integer>(list));
        }
        if (index >= A.length) {
            return;
        }
        for (int i = index; i < A.length; i++) {
            if (A[index] <= target) {
                if (i != index && A[i] == A[i - 1]) {
                    continue;
                }
                list.add(A[i]);
                kSumIIHelper(A, i + 1, target - A[i], count - 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        KSumTwo test = new KSumTwo();
        int[] A = {1, 2, 2, 4, 5};
        int k = 2;
        int target = 6;
        System.out.println(test.kSumII(A, k, target));
    }
}