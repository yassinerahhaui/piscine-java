public class Excalibur {
    private static Excalibur INSTANCE;
    private String name = "Sword";

    private Excalibur() {}

    private Excalibur(String name) {
        this.name = name;
    }

    public static Excalibur getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Excalibur();
        }
        return INSTANCE;
    }

    public String getName() {
        return name;
    }

}