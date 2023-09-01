package zadacha_2;

import java.io.*;

public class FileManager {
    public static void main(String[] args) {
        try {
            writeFile("test.txt", "Hello, world!");
            String content = readFile("test.txt");
            System.out.println("Содержимое файла: " + content);
            copyFile("test.txt", "test_copy.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String fileName, String content) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
        } catch (IOException e) {
            throw new IOException("Ошибка при записи в файл " + fileName, e);
        }
    }

    public static String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new IOException("Ошибка при чтении файла " + fileName, e);
        }
        return content.toString().trim();
    }

    public static void copyFile(String sourceFileName, String targetFileName) throws IOException {
        try (
            FileReader reader = new FileReader(sourceFileName);
            FileWriter writer = new FileWriter(targetFileName)
        ) {
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
        } catch (IOException e) {
            throw new IOException("Ошибка при копировании файла " + sourceFileName + " в " + targetFileName, e);
        }
    }
}