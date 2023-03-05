import java.util.List;
import java.util.Scanner;

public class Application {

    private String choice;

    public void menu() {
        TComplex[][] array = {
                {new TComplex(2, 1), new TComplex(2.1, 1.3), new TComplex(2, 2.6)},
                {new TComplex(3, 2), new TComplex(2.2, 1.4), new TComplex(4, 2.8)},
                {new TComplex(4, 3), new TComplex(2.3, 1.5), new TComplex(2.5, 2.9)}
        };
        Matrix matrix = new Matrix(array);
        do {
            System.out.println("""
                            Введите номер операции над матрицей:\s
                            1 - Ввести значения матрицы\s
                            2 - Найти определитель матрицы\s
                            3 - Сформировать транспонированную матрицу\s
                            4 - Расчитать ранг матрицы\s
                            5 - Вывести матрицу в консоль\s
                            0 - Выйти из приложения\s
                            """
            );
            if (validateChoice()) {
                switch (choice) {
                    case "1" -> matrix.editMatrix();
                    case "2" -> matrix.calculateDeterminant();
                    case "3" -> matrix.transpose();
                    case "4" -> matrix.calculateRank();
                    case "5" -> matrix.printMatrix();
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
            if (List.of("1", "2", "3", "4", "5", "0").contains(choice))
                isValid = true;
            else
                System.out.println("Введите номер из списка:");
        } while (!isValid);
        return isValid;
    }
}
