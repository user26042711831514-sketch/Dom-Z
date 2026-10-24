public class Task2 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};

        // Две проверки: сначала неверный индекс, потом деление на ноль.
        for (int test = 1; test <= 2; test++) {
            try {
                if (test == 1) {
                    int index = 5;
                    System.out.println(numbers[index]);
                } else {
                    int divisor = 0;
                    System.out.println(numbers[0] / divisor);
                }
            } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
                System.out.println(
                        "Перехвачена ошибка: "
                                + e.getClass().getSimpleName()
                );
            }
        }

        System.out.println("Программа продолжила работу");
    }
}