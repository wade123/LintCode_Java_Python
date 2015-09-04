import java.util.*;

public class SingleNumberThree {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        int xor = 0;
        for (int number : A) {
            xor ^= number;
        }
        int check = xor & ~(xor - 1);
        int one = 0;
        int two = 0;
        for (int number : A) {
            if ((number & check) == 0) {
                one ^= number;
            } else {
                two ^= number;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(one);
        result.add(two);
        return result;
    }

    public static void main(String[] args) {
        SingleNumberThree test = new SingleNumberThree();
        int[] numbers = {1,1,2,19,2,3,3,4,4,5,6,6};
        System.out.println(test.singleNumberIII(numbers));
    }
}
