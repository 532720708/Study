package cn.downey.designpattern.abstractFactory.shape;

import cn.downey.designpattern.abstractFactory.api.Shape;

public class Circle implements Shape {
    public void draw() {
        System.out.println("Inside Cirle::draw() method.");
    }
}
