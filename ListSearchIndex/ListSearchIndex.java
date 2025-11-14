import java.util.ArrayList;
import java.util.List;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
        if (list == null) return null;
        Integer lastIndex = list.lastIndexOf(value);
        if (lastIndex == -1) return null;
        return lastIndex;
    }
    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        if (list == null) return null;
        for (Integer i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) return i;
        }
        return null;
    }
    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        List<Integer> result = new ArrayList<>();
        if (list == null) return result;
        for (Integer i = 0;i < list.size() ;i++) {
            if (list.get(i).equals(value)) result.add(i);  
        }
        return result;
    }

    // public static void main(String[] args) {
    //     System.out.println(ListSearchIndex.findLastIndex(List.of(9, 13, 89, 8, 23, 1, 0, 89), 89));
    //     System.out.println(ListSearchIndex.findFirstIndex(List.of(9, 13, 89, 8, 23, 1, 0, 89), 89));
    //     System.out.println(ListSearchIndex.findAllIndexes(List.of(9, 13, 89, 8, 23, 1, 0, 89), 89).toString());
    // }
}