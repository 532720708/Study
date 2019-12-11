package cn.downey.designpattern.abstractFactory.shape;

import cn.downey.designpattern.abstractFactory.api.Shape;

public class Rectangle implements Shape {
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
