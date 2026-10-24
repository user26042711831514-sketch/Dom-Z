import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String text = scanner.nextLine();

        String reversed = new StringBuilder(text)
                .reverse()
                .toString();

        System.out.println("Перевёрнутая строка: " + reversed);

        // Для проверки убираем пробелы и различия регистра.
        String normalized = text.replaceAll("\\s+", "")
                .toLowerCase(java.util.Locale.ROOT);

        String reversedNormalized = new StringBuilder(normalized)
                .reverse()
                .toString();

        if (normalized.equals(reversedNormalized)) {
            System.out.println("Это палиндром");
        } else {
            System.out.println("Это не палиндром");
        }
    }
}