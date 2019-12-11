package cn.downey.designpattern.abstractFactory.shape;

import cn.downey.designpattern.abstractFactory.api.Shape;

public class Square implements Shape {
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
