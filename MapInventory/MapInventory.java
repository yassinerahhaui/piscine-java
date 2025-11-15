import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapInventory {
    public static int getProductPrice(Map<String, Integer> inventory, String productId) {
        if (inventory == null || productId == null || !inventory.containsKey(productId))
            return -1;
        return (int) inventory.get(productId);
    }

    public static List<String> getProductIdsByPrice(Map<String, Integer> inventory, int price) {
        List<String> list = new ArrayList<>();
        if (inventory == null) return list;
        inventory.forEach((key, value) -> {
            if (value == price) list.add(key);
        });
        return list;
    }

    public static void main(String[] args) {
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("P001", 100);
        inventory.put("P002", 50);
        inventory.put("P003", 75);
        inventory.put("P004", 50);
        inventory.put("P005", 75);

        System.out.println(getProductPrice(inventory, "P002")); // Output: 50
        System.out.println(getProductPrice(inventory, "P004")); // Output: 50
        System.out.println(getProductPrice(inventory, "P006")); // Output: -1

        List<String> productsWithPrice50 = getProductIdsByPrice(inventory, 50);
        System.out.println(productsWithPrice50); // Output: [P002, P004]

        List<String> productsWithPrice75 = getProductIdsByPrice(inventory, 75);
        System.out.println(productsWithPrice75); // Output: [P003, P005]

        List<String> productsWithPrice80 = getProductIdsByPrice(inventory, 80);
        System.out.println(productsWithPrice80); // Output: []
    }
}
