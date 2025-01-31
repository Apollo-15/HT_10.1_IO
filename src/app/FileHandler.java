package app;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    private final static String BASE_PATH = "files/";

    public String writeFile(String fileName, String content) {
        String filePath = BASE_PATH + fileName + ".txt";

        File directory = new File(BASE_PATH);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (FileWriter fw = new FileWriter(filePath)) {
            fw.write(content);
            return "Success.";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String readFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(path)) {
            int sym;
            while ((sym = reader.read()) != -1) {
                stringBuilder.append((char) sym);
            }
            return stringBuilder.toString();
        } catch (IOException ex) {
            return "Error: " + ex.getMessage();
        }
    }
}
