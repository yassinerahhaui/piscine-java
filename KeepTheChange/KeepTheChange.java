import java.util.*;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        List<Integer> sortedCoins = new ArrayList<>(coins);
        Collections.sort(sortedCoins, Collections.reverseOrder());
        List<Integer> change = new ArrayList<>();
        int remaning = amount;

        for (int coin : sortedCoins) {
            while (remaning >= coin) {
                change.add(coin);
                remaning -= coin;
            }
        }
        return change;
    }
}