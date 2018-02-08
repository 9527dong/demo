package com.dong.bean;

/**
 * 手机号信息
 */
public class PhoneInfo {
    //手机号前7位
    private String mts;
    //归属地
    private String province;
    //运营商名称
    private String catName;
    //手机号
    private String telString;
    private String areaVid;
    private String ispVid;
    //归属地
    private String carrier;

    public String getTelString() {
        return telString;
    }

    public void setTelString(String telString) {
        this.telString = telString;
    }



    public PhoneInfo(String mts, String province, String catName, String telString, String areaVid, String ispVid, String carrier) {
        this.mts = mts;
        this.province = province;
        this.catName = catName;
        this.telString = telString;
        this.areaVid = areaVid;
        this.ispVid = ispVid;
        this.carrier = carrier;
    }

    public PhoneInfo() {
    }

    public String getMts() {
        return mts;
    }

    public void setMts(String mts) {
        this.mts = mts;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getAreaVid() {
        return areaVid;
    }

    public void setAreaVid(String areaVid) {
        this.areaVid = areaVid;
    }

    public String getIspVid() {
        return ispVid;
    }

    public void setIspVid(String ispVid) {
        this.ispVid = ispVid;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    @Override
    public String toString() {
        return "PhoneInfo{" +
                "mts='" + mts + '\'' +
                ", province='" + province + '\'' +
                ", catName='" + catName + '\'' +
                ", telString='" + telString + '\'' +
                ", areaVid='" + areaVid + '\'' +
                ", ispVid='" + ispVid + '\'' +
                ", carrier='" + carrier + '\'' +
                '}';
    }
}
