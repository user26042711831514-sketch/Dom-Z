import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task4 {
    public static void main(String[] args) {
        int lines = 0;
        int words = 0;
        int characters = 0;

        Path path = Path.of("text.txt");

        try (BufferedReader reader = Files.newBufferedReader(
                path, StandardCharsets.UTF_8)) {

            String line;

            while ((line = reader.readLine()) != null) {
                lines++;
                characters += line.length();

                String trimmed = line.trim();

                if (!trimmed.isEmpty()) {
                    words += trimmed.split("\\s+").length;
                }
            }

            System.out.println("Строк: " + lines);
            System.out.println("Слов: " + words);
            System.out.println("Символов с пробелами: " + characters);

        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл: " + e.getMessage());
            System.out.println("Путь поиска: " + path.toAbsolutePath());
        }
    }
}