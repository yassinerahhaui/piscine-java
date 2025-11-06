// package CatInFile;

import java.io.*;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        if (args == null || args.length == 0)
            return;
        String fileName = args[0];
        try (InputStream in = System.in; FileOutputStream out = new FileOutputStream(fileName)) {
            byte[] buffer = new byte[2024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}