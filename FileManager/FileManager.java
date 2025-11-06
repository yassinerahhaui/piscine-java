import java.io.*;
import java.util.Scanner;

public class FileManager {
    public static void createFile(String fileName, String content) throws IOException {
        File newFile = new File(fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
            writer.write(content);
            // ensure we preserve the final newline if the test expects it
            if (!content.endsWith("\n")) {
                writer.newLine();
            }
        }
    }

    public static String getContentFile(String fileName) throws IOException {
        File fileToRead = new File(fileName);
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileToRead))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString().trim();
    }

    public static void deleteFile(String fileName) {
        File fileToDelete = new File(fileName);
        fileToDelete.delete();
    }
}