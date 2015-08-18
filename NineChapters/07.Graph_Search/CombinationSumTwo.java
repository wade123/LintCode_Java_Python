import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CombinationSumTwo {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) {
            return result;
        }
        Arrays.sort(num);
        List<Integer> list = new ArrayList<Integer>();
        combinationSumHelper(num, 0, target, list, result);
        return result;
    }

    private void combinationSumHelper(int[] num, int index, int target,
        List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
        }
        if (index >= num.length || num[index] > target) {
            return;
        }
        for (int i = index; i < num.length; i++) {
        	if (i != index && num[i] == num[i - 1]) {
        		continue;
        	}
            list.add(num[i]);
            combinationSumHelper(num, i + 1, target - num[i], list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
    	CombinationSumTwo test = new CombinationSumTwo();
    	int[] num = {7,1,2,5,1,6,10};
    	int target = 8;
    	System.out.println(test.combinationSum2(num, target));
    	
    }
}