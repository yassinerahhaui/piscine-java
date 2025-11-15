import java.util.*;

public class Wedding {
    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {
        List<String> listFirst = new ArrayList<>(first);
        List<String> listSecond = new ArrayList<>(second);

        Map<String, String> couples = new HashMap<>();
        int pairCount = Math.min(listFirst.size(), listSecond.size());

        for (int i = 0; i < pairCount; i++) {
            couples.put(listFirst.get(i), listSecond.get(i));
        }

        return couples;
    }
}