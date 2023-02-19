
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
        if (matrix.length==2){
            calcResult = matrix[0][0].doubleValue() * matrix[1][1].doubleValue() - matrix[1][0].doubleValue() * matrix[0][1].doubleValue();
        }
        else{
            int koeff=1;
            for(int i = 0; i< matrix.length; i++){
                if(i%2==1){
                    koeff=-1;
                }
                else{
                    koeff=1;
                }
                calcResult += koeff*matrix[0][i].doubleValue() * calculateDeterminant(getMinor(matrix,0,i));
            }
        }
        return calcResult;
    }

    private Double[][] getMinor(Number[][] matrix, int row, int column) {
        int minorLength = matrix.length-1;
        Double[][] minor = new Double[minorLength][minorLength];
        int dI=0;
        int dJ=0;
        for(int i=0; i<=minorLength; i++){
            dJ=0;
            for(int j=0; j<=minorLength; j++){
                if(i==row){
                    dI=1;
                }
                else{
                    if(j==column){
                        dJ=1;
                    }
                    else{
                        minor[i-dI][j-dJ] = matrix[i][j].doubleValue();
                    }
                }
            }
        }
        return minor;
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
