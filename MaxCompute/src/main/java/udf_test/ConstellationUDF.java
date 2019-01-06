package udf_test;

import com.aliyun.odps.udf.UDF;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ConstellationUDF extends UDF {
    private final static int[] dayArr = new int[] { 20, 19, 21, 20, 21, 22, 23, 23, 23, 24, 23, 22 };
    private final static String[] constellationArr = new String[] { "摩羯座", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };

    public String evaluate(Date date) {
        if (date == null){
            return "";
        }
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return localDate.getDayOfMonth() < dayArr[localDate.getMonthValue() - 1] ? constellationArr[localDate.getMonthValue() - 1] : constellationArr[localDate.getMonthValue()]; 
    }
}