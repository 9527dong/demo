package udf_test;

import com.aliyun.odps.udf.UDF;

import java.math.BigDecimal;

public class IntAverageLevel extends UDF {
    public Integer evaluate(int average, int current) {
        int difference = average - current;
        if (difference >= 0){
            return 1;
        }
        return 0;
    }
}