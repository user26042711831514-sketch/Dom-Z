import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private transient String password;

    public Student(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Имя: " + name
                + ", возраст: " + age
                + ", пароль: " + password;
    }
}

public class Task5 {
    public static void main(String[] args) {
        Student student = new Student("Роман", 18, "12345");

        System.out.println("До сохранения:");
        System.out.println(student);

        // Сохраняем объект в файл.
        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("student.dat"))) {

            output.writeObject(student);
            System.out.println("Объект сохранён");

        } catch (IOException e) {
            System.out.println("Ошибка сохранения: " + e.getMessage());
            return;
        }

        // Восстанавливаем объект из файла.
        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("student.dat"))) {

            Student restored = (Student) input.readObject();

            System.out.println("После восстановления:");
            System.out.println(restored);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }
}