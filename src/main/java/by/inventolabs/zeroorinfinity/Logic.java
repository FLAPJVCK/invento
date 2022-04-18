package by.inventolabs.zeroorinfinity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Logic {
    private static final int SCALE = 8;

    public static BigDecimal zeroOrInfinity(int n) {
        BigDecimal un;
        BigDecimal sumFactorials = BigDecimal.valueOf(0);
        for (int i = 1; i <= n; i++) {
            sumFactorials = sumFactorials.add(calcFactorial(i));
        }
        un = sumFactorials.divide(calcFactorial(n), SCALE, RoundingMode.DOWN);
        return un;
    }

    public static BigDecimal calcFactorial(int n) {
        BigDecimal factorial = BigDecimal.valueOf(1);
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigDecimal.valueOf(i));
        }
        return factorial;
    }
}
