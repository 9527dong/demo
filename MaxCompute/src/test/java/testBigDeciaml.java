import java.math.BigDecimal;

public class testBigDeciaml {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal(2.5);
        BigDecimal bigDecimal2 = new BigDecimal(2.5);
        System.out.println(bigDecimal1.subtract(bigDecimal2).doubleValue() > 0);
    }
}
