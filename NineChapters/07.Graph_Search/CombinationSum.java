import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CombinationSum {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        combinationSumHelper(candidates, 0, target, list, result);
        return result;
    }

    private void combinationSumHelper(int[] candidates, int index, int target,
        List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
        }
        if (index >= candidates.length || candidates[index] > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSumHelper(candidates, i, target - candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum test = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(test.combinationSum(candidates, target));
    }
}