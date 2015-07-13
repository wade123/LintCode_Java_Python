import java.util.ArrayList;
import java.util.Collections;

public class Subsets {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.size() == 0) {
            return result;
        }
        Collections.sort(S);
        ArrayList<Integer> list = new ArrayList<Integer>();
        subsetsHelper(S, result, list, 0);
        return result;
    }

    private void subsetsHelper(ArrayList<Integer> S, ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list, int index) {
        result.add(new ArrayList<Integer>(list));
        for (int i = index; i < S.size(); i++) {
            list.add(S.get(i));
            subsetsHelper(S, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets test = new Subsets();
        ArrayList<Integer> S = new ArrayList<Integer>();
        S.add(1);
        S.add(2);
        S.add(3);
        System.out.println(test.subsets(S));
    }
}
