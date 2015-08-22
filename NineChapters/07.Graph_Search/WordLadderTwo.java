import java.util.*;

public class WordLadderTwo {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<>();
        if (start == null || end == null) {
            return result;
        }
        ArrayList<String> tmparray = new ArrayList<String>();
        
        //如果start与end相等，直接返回
        if (start.equals(end)) {
            tmparray.add(start);
            tmparray.add(end);
            result.add(tmparray);
            return result;
        }
        
        //新建一个hashmap，保存每个节点的所有前驱。
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        map.put(end, new ArrayList<String>());
        map.put(start, new ArrayList<String>());
        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }
        
        //利用bfs 层序遍历 如果队列中有end 那么结束遍历（到最短的一层就结束）
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        ArrayList<String> currentlevel = new ArrayList<String>();
        while (!queue.isEmpty()) {
            int level = queue.size();
            currentlevel.clear();
            for (int i = 0; i < level; i++) {
                String top = queue.poll();
                if (dict.contains(top)) {
                    dict.remove(top);
                }
                currentlevel.add(top);
            }
            
            //循环每个String的每个char 从a到z，在dict里面找是否有
            for (String curs : currentlevel) {
                for (int i = 0; i < curs.length(); ++i) {
                    for (char j = 'a'; j <= 'z'; ++j) {
                        char[] tmpchar = curs.toCharArray();
                        tmpchar[i] = j;
                        String tmps = new String(tmpchar);
                        if (!curs.equals(start) && tmps.equals(end)) {
                            map.get(end).add(curs);
                            queue.offer(tmps);
                        } else if (!tmps.equals(curs) && dict.contains(tmps)) {
                            if (!queue.contains(tmps)) {
                                queue.offer(tmps);
                            }
                            map.get(tmps).add(curs);
                        }
                    }
                }
            }
            if (queue.contains(end)) {
                break;
            }
        }
        tmparray.add(end);
        buildpath(start, end, map, tmparray, result);
        return result;
    }
    
    //根据节点的前驱 生成路径
    private void buildpath(String start, String end,
            Map<String, ArrayList<String>> map, ArrayList<String> tmparray,
            List<List<String>> result) {
        ArrayList<String> pre = map.get(end);
        if (end.equals(start)) {
            ArrayList<String> tmparray2 = new ArrayList<String>(tmparray);
            Collections.reverse(tmparray2);
            result.add(tmparray2);
            return;
        }
        for (String s: pre) {
            tmparray.add(s);
            buildpath(start, s, map, tmparray, result);
            tmparray.remove(tmparray.size() - 1);
        }
            
    }

    public static void main(String[] args) {
        WordLadderTwo test = new WordLadderTwo();
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<>();
        dict.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(dict);
        System.out.println(test.findLadders(start, end, dict));
    }
}