// package DoOp;

public class DoOp {
    public static String operate(String[] args) {
        if (args.length != 3) {
            return "Error";
        }
        if (args[2] == "0" && args[1] == "%") {
            return "Error";
        }
        var num = switch (args[1]) {
            case "+" -> Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
            case "-" -> Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
            case "*" -> Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
            case "/" -> Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
            case "%" -> Integer.parseInt(args[0]) % Integer.parseInt(args[2]);
            default -> "Error";
        };
        return num.toString();
    }

    // public static void main(String[] args) {
    //     System.out.println(DoOp.operate(new String[]{"1","+","2"}));
    //     System.out.println(DoOp.operate(new String[]{"1","-","1"}));
    //     System.out.println(DoOp.operate(new String[]{"1","%","0"}));
    //     System.out.println(DoOp.operate(args));
    // }
}