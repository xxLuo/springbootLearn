package com.test.bean;

public class Color {
    private Car car;
    public Color(Car car){
        this.car=car;
    }

    public Color() {

    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }
}
