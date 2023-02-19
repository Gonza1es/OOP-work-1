import java.util.List;
import java.util.Scanner;

public class Application {

    private String choice;

    public void menu() {
        Double[][] array = { {2.4, 1.8, 5.2}, {4.7, 8.12, 2.32}, {6.4, 1.6, 2.2}};
        Matrix matrix = new Matrix(array);
        do {
            System.out.println("""
                            Введите номер операции над матрицей:\s
                            1 - Ввести значения матрицы\s
                            2 - Найти определитель матрицы\s
                            3 - Сформировать транспонированную матрицу\s
                            4 - Вывести матрицу в консоль\s
                            0 - Выйти из приложения\s
                            """
            );
            if (validateChoice()) {
                switch (choice) {
                    case "1" -> System.out.println("Выбрана 1");
                    case "2" -> matrix.calculateDeterminant();
                    case "3" -> System.out.println("Выбрана 3");
                    case "4" -> matrix.printMatrix();
                    case "0" -> System.out.println("До свидания!");
                }
            }
        } while (!choice.equals("0"));
    }

    private boolean validateChoice() {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        do {
            choice = scanner.nextLine();
            if (List.of("1", "2", "3", "4","0").contains(choice))
                isValid = true;
            else
                System.out.println("Введите номер из списка:");
        } while (!isValid);
        return isValid;
    }
}
