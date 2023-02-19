import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Matrix {

    private final Number[][] matrix;

    private final int size;


    public Matrix(Number[][] matrix) {
        this.size = matrix.length;
        this.matrix = matrix.clone();
    }

    public void calculateDeterminant() {
        System.out.println("Определитель матрицы = " + calculateDeterminant(matrix));
    }

    private Double calculateDeterminant(Number[][] matrix) {
        Double calcResult = 0.0;
        if (matrix.length == 2) {
            calcResult = matrix[0][0].doubleValue() * matrix[1][1].doubleValue() - matrix[1][0].doubleValue() * matrix[0][1].doubleValue();
        } else {
            int koeff = 1;
            for (int i = 0; i < matrix.length; i++) {
                if (i % 2 == 1) {
                    koeff = -1;
                } else {
                    koeff = 1;
                }
                calcResult += koeff * matrix[0][i].doubleValue() * calculateDeterminant(getMinor(matrix, 0, i));
            }
        }
        return calcResult;
    }

    private Double[][] getMinor(Number[][] matrix, int row, int column) {
        int minorLength = matrix.length - 1;
        Double[][] minor = new Double[minorLength][minorLength];
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
                        minor[i - dI][j - dJ] = matrix[i][j].doubleValue();
                    }
                }
            }
        }
        return minor;
    }

    public void transpose() {
        Number[][] transposeMatrix = new Number[matrix.length][matrix.length];

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
        System.out.println("Введите новые значения матрицы: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
    }

    public void calculateRank() {
        double EPS = 1E-9;
        double[][] currentMatrix = new double[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                currentMatrix[i][j] = matrix[i][j].doubleValue();
            }
        }
        int rank = matrix.length;
        List<Boolean> lineUsed = new ArrayList<>();
        int j;
        for (int i = 0; i < matrix.length; i++) {
            lineUsed.add(i, false);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix.length; j++)
                if (!lineUsed.get(j) && Math.abs(currentMatrix[j][i]) > EPS)
                    break;
            if (j == matrix.length)
                --rank;
            else {
                lineUsed.set(j, true);
                for (int p = i + 1; p < matrix.length; ++p)
                    currentMatrix[j][p] /= currentMatrix[j][i];
                for (int k = 0; k < matrix.length; ++k)
                    if (k != j && Math.abs(currentMatrix[k][i]) > EPS)
                        for (int p = i + 1; p < matrix.length; ++p)
                            currentMatrix[k][p] -= currentMatrix[j][p] * currentMatrix[k][i];
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
