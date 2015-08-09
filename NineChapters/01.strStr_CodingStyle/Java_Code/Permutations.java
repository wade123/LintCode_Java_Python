import java.util.ArrayList;

public class Permutations {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        permuteHelper(nums, result, list);
        return result;
    }

    private void permuteHelper(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list) {
        if (list.size() == nums.size()) {
            result.add(new ArrayList<Integer>(list));
        }
        for (int i = 0; i < nums.size(); i++) {
            if (list.contains(nums.get(i))) {
                continue;
            }
            list.add(nums.get(i));
            permuteHelper(nums, result, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations test = new Permutations();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        System.out.println(test.permute(nums));
    }
}

