package udf_test;

import com.aliyun.odps.udf.UDF;

import java.math.BigDecimal;

public class BigDeciamlAverageLevel extends UDF {
    // TODO define parameters and return type, e.g:  public String evaluate(String a, String b)
    public String evaluate(BigDecimal average, BigDecimal current) {
        BigDecimal difference = average.subtract(current);

        if (difference.doubleValue() >= 0){
            return "1";
        }
        return "0" ;
    }


}
