import java.util.*;

public class WeddingComplex {

    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
        Map<String, String> matches = new HashMap<>();
        Map<String, String> result = new HashMap<>();

        Map<String, Integer> proposalIndex = new HashMap<>();
        for (String f : first.keySet()) {
            proposalIndex.put(f, 0);
        }

        Map<String, Map<String, Integer>> secondPrefsRank = new HashMap<>();
        for (String s : second.keySet()) {
            Map<String, Integer> rank = new HashMap<>();
            List<String> prefs = second.get(s);
            for (int i = 0; i < prefs.size(); i++) {
                rank.put(prefs.get(i), i);
            }
            secondPrefsRank.put(s, rank);
        }

        Queue<String> freeFirst = new LinkedList<>(first.keySet());

        while (!freeFirst.isEmpty()) {
            String f = freeFirst.poll();
            List<String> prefs = first.get(f);
            int index = proposalIndex.get(f);
            String s = prefs.get(index);

            proposalIndex.put(f, index + 1);

            if (!matches.containsKey(s)) {
                matches.put(s, f);
            } else {
                String current = matches.get(s);
                Map<String, Integer> rank = secondPrefsRank.get(s);
                if (rank.get(f) < rank.get(current)) {
                    matches.put(s, f);
                    freeFirst.add(current);
                } else {
                    freeFirst.add(f);
                }
            }
        }

        for (Map.Entry<String, String> entry : matches.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }

        return result;
    }

}