import java.util.*;

public class FourSum {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
// using 2 pointers, O(n^3) time, O(1) extra space
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length < 4) {
            return result;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 3; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length - 2; j++) {
                if (j != i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int start = j + 1;
                int end = numbers.length - 1;
                while (start < end) {
                    int sum = numbers[i] + numbers[j] + numbers[start] + numbers[end];
                    if (sum == target) {
                        ArrayList<Integer> oneGroup = new ArrayList<>(Arrays.asList(
                            numbers[i], numbers[j], numbers[start], numbers[end]));
                        result.add(oneGroup);
                        start++;
                        end--;
                        while (start != j + 1 && numbers[start] == numbers[start - 1]
                            && start < numbers.length - 1) {
                            start++;
                        }
                        while (end != numbers.length - 1 && numbers[end] == numbers[end + 1]
                            && end > j + 1) {
                            end--;
                        }
                    } else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return result;
    }
// using hashMap: O(n^2) time, O(n^2) space
    public ArrayList<ArrayList<Integer>> fourSum2(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length < 4) {
            return result;
        }
        Arrays.sort(numbers);
        Map<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (!map.containsKey(sum)) {
                    ArrayList<ArrayList<Integer>> pairList = new ArrayList<>();
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    pairList.add(pair);
                    map.put(sum, pairList);
                } else {
                    ArrayList<ArrayList<Integer>> temp = map.get(sum);
                    temp.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                    map.put(sum, temp);
                }
            }
        }
        Set<ArrayList<Integer>> set = new HashSet<>();
        for (Integer sum : map.keySet()) {
            if (map.containsKey(target - sum)) {
                if (target - sum == sum && map.get(sum).size() == 1) {
                    continue;
                }
                for (ArrayList<Integer> pairOne : map.get(sum)) {
                    for (ArrayList<Integer> pairTwo : map.get(target - sum)) {
                        if (pairOne == pairTwo) {
                            continue;
                        }
                        if (pairOne.contains(pairTwo.get(0))
                            || pairOne.contains(pairTwo.get(1))) {
                            continue;
                        }
                        ArrayList<Integer> pairToAdd = new ArrayList<>(Arrays.asList(
                            numbers[pairOne.get(0)], numbers[pairOne.get(1)],
                            numbers[pairTwo.get(0)], numbers[pairTwo.get(1)]));
                        Collections.sort(pairToAdd);
                        set.add(pairToAdd);
                    }
                }
            }
        }
        result.addAll(set);
        return result;
    }

    public static void main(String[] args) {
        FourSum test = new FourSum();
        int[] numbers = {1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,0,0,-2,2,-5,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99};
        System.out.println(test.fourSum(numbers, 11));
    }
}