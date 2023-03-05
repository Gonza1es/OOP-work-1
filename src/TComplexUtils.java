public class TComplexUtils {


    public static TComplex sum(TComplex first, TComplex second) {
        Number firstSum = first.doubleValue() + second.doubleValue();
        Number secondSum = second.doubleImaginaryValue() + second.doubleImaginaryValue();

        return new TComplex(firstSum, secondSum);
    }

    public static TComplex subtract(TComplex first, TComplex second) {
        Number firstSubtract = first.doubleValue() - second.doubleValue();
        Number secondSubtract = second.doubleImaginaryValue() - second.doubleImaginaryValue();

        return new TComplex(firstSubtract, secondSubtract);
    }

    public static TComplex multiply(TComplex first, TComplex second) {
        Number firstResult = first.doubleValue() * second.doubleValue() - first.doubleImaginaryValue()* second.doubleImaginaryValue();
        Number secondResult = first.doubleValue() * second.doubleImaginaryValue() + first.doubleImaginaryValue() * second.doubleValue();

        return new TComplex(firstResult, secondResult);
    }

    public static TComplex multiplyByNumber(int first, TComplex second) {
        Number firstResult = first * second.doubleValue();
        Number secondResult = first * second.doubleImaginaryValue();

        return new TComplex(firstResult, secondResult);
    }

    public static TComplex division(TComplex first, TComplex second) {
        Number denominator = Math.pow(second.doubleValue(), 2) + Math.pow(second.doubleImaginaryValue(), 2);
        Number firstNumerator = first.doubleValue() * second.doubleValue() + first.doubleImaginaryValue()* second.doubleImaginaryValue();
        Number secondNumerator = first.doubleValue() * second.doubleImaginaryValue() - first.doubleImaginaryValue() * second.doubleValue();
        Number firstResult = firstNumerator.doubleValue() / denominator.doubleValue();
        Number secondResult = secondNumerator.doubleValue() / denominator.doubleValue();

        return new TComplex(firstResult, secondResult);
    }

    public static double abs(TComplex complex) {
        return Math.sqrt(Math.pow(complex.doubleValue(), 2) + Math.pow(complex.doubleImaginaryValue(), 2));
    }
}
