import java.util.*;

public class MajorityNumberThree {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(k);
        for (int number : nums) {
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else if (map.size() < k) {
                map.put(number, 1);
            } else {
                removeKey(map);
                map.put(number, 1);
            }
        }
        for (Integer key : map.keySet()) {
            map.put(key, 0);
        }
        int major = 0;
        int count = 0;
        for (int number : nums) {
            if (map.containsKey(number)) {
                int temp = map.get(number) + 1;
                if (temp > count) {
                    count = temp;
                    major = number;
                }
                map.put(number, temp);
            }
        }
        return major;
    }

    private void removeKey(Map<Integer, Integer> map) {
        ArrayList<Integer> keysToRemove = new ArrayList<>();
        for (Integer key : map.keySet()) {
            Integer temp = map.get(key) - 1;
            if (temp == 0) {
                keysToRemove.add(key);
            } else {
                map.put(key, temp);
            }
        }
        for (Integer key : keysToRemove) {
            map.remove(key);
        }
    }

    public static void main(String[] args) {
        MajorityNumberThree test = new MajorityNumberThree();
        ArrayList<Integer> ns = new ArrayList<Integer>(Arrays.asList(3,1,2,3,2,3,3,4,4,4));
        System.out.println(test.majorityNumber(ns, 3));
    }
}