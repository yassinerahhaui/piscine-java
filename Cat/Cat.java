package Cat;

import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        try {
            FileReader fileData = new FileReader(args[0]);
            int c;
            while ((c = fileData.read()) != -1) {
                System.out.print((char)c);
            }
            fileData.close();   
            
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }
}