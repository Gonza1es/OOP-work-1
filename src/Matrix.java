import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matrix {

    private final TComplex[][] matrix;
    private final int size;


    public Matrix(Number[][] matrix) {
        this.size = matrix.length;
        this.matrix = (TComplex[][]) matrix.clone();
    }

    public void calculateDeterminant() {
        System.out.println("Определитель матрицы = " + calculateDeterminant(matrix));
    }

    private TComplex calculateDeterminant(TComplex[][] matrix) {
        TComplex calcResult = new TComplex(0, 0);
        if (matrix.length == 2) {
            TComplexUtils.multiply(matrix[0][0], matrix[1][1]);
            calcResult = TComplexUtils.subtract(TComplexUtils.multiply(matrix[0][0], matrix[1][1]),TComplexUtils.multiply(matrix[1][0], matrix[0][1]));
        } else {
            int koeff = 1;
            for (int i = 0; i < matrix.length; i++) {
                if (i % 2 == 1) {
                    koeff = -1;
                } else {
                    koeff = 1;
                }
                calcResult = TComplexUtils.sum(calcResult, TComplexUtils.multiply(TComplexUtils.multiplyByNumber(koeff,matrix[0][i]), calculateDeterminant(getMinor(matrix, 0, i))));
            }
        }
        return calcResult;
    }

    private TComplex[][] getMinor(TComplex[][] matrix, int row, int column) {
        int minorLength = matrix.length - 1;
        TComplex[][] minor = new TComplex[minorLength][minorLength];
        int dI = 0;
        int dJ = 0;
        for (int i = 0; i <= minorLength; i++) {
            dJ = 0;
            for (int j = 0; j <= minorLength; j++) {
                if (i == row) {
                    dI = 1;
                } else {
                    if (j == column) {
                        dJ = 1;
                    } else {
                        minor[i - dI][j - dJ] = matrix[i][j];
                    }
                }
            }
        }
        return minor;
    }

    public void transpose() {
        TComplex[][] transposeMatrix = new TComplex[matrix.length][matrix.length];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }

        System.out.println("Транспонированная матрица: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(transposeMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void editMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новые значения матрицы (Пример - 1+2i): ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                while(true) {
                    String complex = scanner.nextLine();
                    try {
                        matrix[i][j] = new TComplex(complex);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    public void calculateRank() {
        double EPS = 1E-9;
        TComplex[][] currentMatrix = new TComplex[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, currentMatrix[i], 0, matrix.length);
        }
        int rank = matrix.length;
        List<Boolean> lineUsed = new ArrayList<>();
        int j;
        for (int i = 0; i < matrix.length; i++) {
            lineUsed.add(i, false);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix.length; j++)
                if (!lineUsed.get(j) && TComplexUtils.abs(currentMatrix[j][i]) > EPS)
                    break;
            if (j == matrix.length)
                --rank;
            else {
                lineUsed.set(j, true);
                for (int p = i + 1; p < matrix.length; ++p)
                    currentMatrix[j][p] = TComplexUtils.division(currentMatrix[j][p], currentMatrix[j][i]);
                for (int k = 0; k < matrix.length; ++k)
                    if (k != j && TComplexUtils.abs(currentMatrix[k][i]) > EPS)
                        for (int p = i + 1; p < matrix.length; ++p)
                            currentMatrix[k][p] = TComplexUtils.division(currentMatrix[k][p],TComplexUtils.multiply(currentMatrix[j][p], currentMatrix[k][i]));
            }
        }
        System.out.println("Ранг матрицы = " + rank);
    }

        public void printMatrix() {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
}
