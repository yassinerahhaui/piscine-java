import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortList {

    public static List<Integer> sort(List<Integer> list) {
        return list.stream().sorted().collect(Collectors.toList());
    }

    public static List<Integer> sortReverse(List<Integer> list) {
        return  list.stream()
                    .sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());
    }

    // public static void main(String[] args) {
    //     System.out.println(sort(List.of(15, 1, 14, 18, 14, 98, 54, -1, 12)).toString());
    //     System.out.println(sortReverse(List.of(15, 1, 14, 18, 14, 98, 54, -1, 12)).toString());
    // }
}