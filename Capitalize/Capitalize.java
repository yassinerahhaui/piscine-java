import java.io.*;
import java.util.Scanner;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args == null || args.length < 2)
            return;

        File file1 = new File(args[0]);
        File file2 = new File(args[1]);

        Scanner scanner = new Scanner(file1);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            String[] words = line.split("\\s+");
            StringBuilder capitalizedLine = new StringBuilder();

            for (String word : words) {
                if (!word.isEmpty()) {
                    capitalizedLine.append(Character.toUpperCase(word.charAt(0)))
                            .append(word.substring(1).toLowerCase())
                            .append(" ");
                }
            }

            writer.write(capitalizedLine.toString().trim());
            // writer.newLine();
        }

        scanner.close();
        writer.close();
    }
}