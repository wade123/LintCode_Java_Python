import java.util.*;

public class ProductOfArrayExcludeItself {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> result = new ArrayList<>(Collections.nCopies(A.size(), (long) 1));
        for (int i = 1; i < A.size(); i++) {
            result.set(i, result.get(i - 1) * A.get(i - 1));
        }
        long last = 1; // can NOT use int, because it will overflow!!!
        for (int i = A.size() - 1; i >= 1; i--) {
            last *= A.get(i);
            result.set(i - 1, result.get(i - 1) * last);
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExcludeItself test = new ProductOfArrayExcludeItself();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(test.productExcludeItself(A));
    }
}