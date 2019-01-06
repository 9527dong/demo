package udf_test;

import com.aliyun.odps.udf.UDF;

import java.math.BigDecimal;

public class BigDeciamlLevel extends UDF {
    public String evaluate(BigDecimal monetary) {
        if (monetary == null) {
            return "0";
        }
        return monetaryLevel(monetary).toString();
    }

    private Integer monetaryLevel(BigDecimal monetary) {

        if (monetary.doubleValue() < 120) {
            return 1;
        }
        if (monetary.doubleValue() < 250) {
            return 2;
        }
        if (monetary.doubleValue() < 480) {
            return 3;
        }
        if (monetary.doubleValue() < 1000) {
            return 4;
        }
        if (monetary.doubleValue() >= 1000) {
            return 5;
        }
        return 0;
    }
}