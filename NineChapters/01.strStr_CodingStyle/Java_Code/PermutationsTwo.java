import java.util.ArrayList;
import java.util.Collections;

public class PermutationsTwo {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        Collections.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[nums.size()];
        permuteUniqueHelper(nums, result, list, visited);
        return result;
    }

    private void permuteUniqueHelper(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list, int[] visited) {
        if (list.size() == nums.size()) {
            result.add(new ArrayList<Integer>(list));
        }
        for (int i = 0; i < nums.size(); i++) {
            if (visited[i] != 0
                || i != 0 && nums.get(i) == nums.get(i - 1) && visited[i - 1] == 0) {
                continue;
            }
            list.add(nums.get(i));
            visited[i] = 1;
            permuteUniqueHelper(nums, result, list, visited);
            visited[i] = 0;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        PermutationsTwo test = new PermutationsTwo();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(2);
        System.out.println(test.permuteUnique(nums));
    }
}

