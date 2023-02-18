import java.util.Random;

public class Matrix {

    private final Number[][] matrix;

    private final int size;


    public Matrix(int size) {
        this.size = size;
        this.matrix = new Number[size][size];

        for (int i=0; i < size; i++) {
            for (int j=0; j< size; j++) {
                matrix[i][j] = new Random().nextDouble(10);
            }
        }
    }

    public void printMatrix() {
        for (int i=0; i < size; i++) {
            for (int j=0; j< size; j++) {
                System.out.format(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
