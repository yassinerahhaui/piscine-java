import java.io.File;

public class FileSearch {
    public static String searchFile(String fileName) {
        File documents = new File("documents");
        return searchInDirectory(documents, fileName);
    }

    private static String searchInDirectory(File dir, String fileName) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    String found = searchInDirectory(f, fileName);
                    if (found != null) {
                        return found;
                    }
                }
                if (fileName.equals(f.getName())) {
                    return f.getPath();
                }
            }
        }
        return null;
    }
}