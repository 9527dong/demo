package udf_test;

import com.aliyun.odps.udf.UDF;
import com.aliyun.odps.utils.StringUtils;

import java.math.BigDecimal;

public class RMFLevel extends UDF {

    public String evaluate(Long a, String type) {
        if (StringUtils.isBlank(type)){
            return "0";
        }
        if ("frequency".equals(type)){
            return frequencyLevel(a).toString();
        }

        if ("recency".equals(type)){
            return recencyLevel(a).toString();
        }
        return "0";
    }
//    public Integer evaluate(BigDecimal monetary, String type) {
//        if (monetary == null) {
//            return 0;
//        }
//        return monetaryLevel(monetary);
//    }
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
    private Integer recencyLevel(Long recency){
        if (recency< 37){
            return 5;
        }
        if (recency < 66){
            return 4;
        }
        if (recency < 105){
            return 3;
        }
        if (recency < 158){
            return 2;
        }
        if (recency >= 158){
            return 1;
        }
        return 0;
    }

    private Integer frequencyLevel(Long frequency){
        if (frequency == 1){
            return 1;
        }
        if (frequency == 2){
            return 2;
        }
        if (frequency == 3){
            return 3;
        }
        if (frequency == 4){
            return 4;
        }
        if (frequency > 4){
            return 5;
        }
        return 0;
    }

}