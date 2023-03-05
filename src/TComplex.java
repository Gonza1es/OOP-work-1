import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TComplex extends Number {

    private final Number real;
    private final Number imaginary;

    private static final Pattern pattern = Pattern.compile("^[-]?[0-9]*[.,]?[0-9]*[+]{1}[-]?[0-9]*[.,]?[0-9]*[i]$");

    public TComplex(Number real, Number imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public TComplex(String complexString) throws Exception {
        Matcher matcher = pattern.matcher(complexString);
        if (!matcher.matches()) {
            throw new Exception("Неверный формат строки");
        }
        String[] values = complexString.split("\\+");
        values[1] = values[1].replaceAll("i","");
        this.real = Double.valueOf(values[0]);
        this.imaginary = Double.valueOf(values[1]);
    }

    @Override
    public int intValue() {
        return real.intValue();
    }

    public int intImaginaryValue() {
        return imaginary.intValue();
    }

    @Override
    public long longValue() {
        return real.longValue();
    }

    public long longImaginaryValue() {
        return imaginary.longValue();
    }

    @Override
    public float floatValue() {
        return real.floatValue();
    }

    public float floatImaginaryValue() {
        return imaginary.floatValue();
    }

    @Override
    public double doubleValue() {
        return real.doubleValue();
    }

    public double doubleImaginaryValue() {
        return imaginary.doubleValue();
    }

    @Override
    public String toString() {
        return real.doubleValue() + "+" + imaginary.doubleValue() + "i";
    }
}
