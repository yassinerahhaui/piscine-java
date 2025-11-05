// package CleanExtract;

public class CleanExtract {
    public static String extract(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (String part : s.split("\\|")) {
            part = part.trim();
            if (part.isEmpty()) {
                continue;
            }
            if (!part.contains(".") && !part.isEmpty()) {
                result.append(part);
                result.append(" ");
            }
            int start = part.indexOf(".");
            int end = part.lastIndexOf(".");
            if (start != end && start != -1) {
                String newPart = part.substring(start + 1, end).trim();
                if (newPart.isEmpty()) {
                    continue;
                }
                result.append(newPart);
                result.append(" ");
            } else if (start != -1 && start == end) {
                String newPart = part.substring(start + 1).trim();
                if (newPart.isEmpty()) {
                    continue;
                }
                result.append(newPart);
                result.append(" ");
            }
        }

        return result.toString().trim();
    }
}