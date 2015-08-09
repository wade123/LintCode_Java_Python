import java.util.ArrayList;
import java.util.Collections;

public class SubsetsTwo {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.size() == 0) {
            return result;
        }
        Collections.sort(S);
        ArrayList<Integer> list = new ArrayList<Integer>();
        subsetsWithDupHelper(S, result, list, 0);
        return result;
    }

    private void subsetsWithDupHelper(ArrayList<Integer> S, ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list, int index) {
        result.add(new ArrayList<Integer>(list));
        for (int i = index; i < S.size(); i++) {
            if (i != index && S.get(i) == S.get(i - 1)) {
                continue;
            }
            list.add(S.get(i));
            subsetsWithDupHelper(S, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsTwo test = new SubsetsTwo();
        ArrayList<Integer> S = new ArrayList<Integer>();
        S.add(1);
        S.add(2);
        S.add(2);
        System.out.println(test.subsetsWithDup(S));
    }
}

