package cn.downey.designpattern.abstractFactory;

import cn.downey.designpattern.abstractFactory.api.Color;
import cn.downey.designpattern.abstractFactory.api.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
