import java.util.*;

public class ThreeSum {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return result;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (numbers[i] > 0) {
                break;
            }
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int target = -numbers[i];
            int start = i + 1;
            int end = numbers.length - 1;
            while (start < end) {
                while (start != i + 1 && numbers[start] == numbers[start - 1]
                    && start < end) {
                    start++;
                }
                if (start == end) {
                    break;
                }
                int sum = numbers[start] + numbers[end];
                if (sum == target) {
                    result.add(new ArrayList<Integer>(
                        Arrays.asList(numbers[i], numbers[start], numbers[end])));
                    start++;
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();
        int[] numbers = {0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(test.threeSum(numbers));
    }
}
