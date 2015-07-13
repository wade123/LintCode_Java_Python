import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (S == null || S.length == 0) {
    		return result;
    	}
    	Arrays.sort(S);
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	subsetsHelper(S, result, list, 0);
    	return result;
    }

    private void subsetsHelper(int[] S, ArrayList<ArrayList<Integer>> result,
    	ArrayList<Integer> list, int index) {
    	result.add(new ArrayList<Integer>(list));
    	for (int i = index; i < S.length; i++) {
    		list.add(S[i]);
    		subsetsHelper(S, result, list, i + 1);
    		list.remove(list.size() - 1);
    	}
    }

    public static void main(String[] args) {
    	Subsets test = new Subsets();
    	int[] S = {1, 2, 3};
    	System.out.println(test.subsets(S));
    }
}
