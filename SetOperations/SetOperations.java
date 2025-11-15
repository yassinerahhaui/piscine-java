import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> merged = new HashSet<>();
        merged.addAll(set1);
        merged.addAll(set2);
        return merged;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>();
        set1.forEach(el -> {
            if (set2.contains(el)) {
                result.add(el);
            }
        });
        return result;
    }
}