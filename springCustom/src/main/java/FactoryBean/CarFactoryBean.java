package FactoryBean;

import org.springframework.beans.factory.FactoryBean;
import pojo.Car;

public class CarFactoryBean implements FactoryBean<Car> {
    private String carInfo;

    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.valueOf(infos[1]));
        car.setPrice(Double.valueOf(infos[2]));
        return car;
    }

    public Class<Car> getObjectType() {
        return Car.class;
    }

    public boolean isSingleton() {
        return false;
    }

    public String getCarInfo() {
        return this.carInfo;
    }

    // 接受逗号分割符设置属性信息  
    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }
}   