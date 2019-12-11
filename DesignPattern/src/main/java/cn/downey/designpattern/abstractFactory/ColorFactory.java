package cn.downey.designpattern.abstractFactory;

import cn.downey.designpattern.abstractFactory.api.Color;
import cn.downey.designpattern.abstractFactory.api.Shape;
import cn.downey.designpattern.abstractFactory.color.Blue;
import cn.downey.designpattern.abstractFactory.color.Green;
import cn.downey.designpattern.abstractFactory.color.Red;

public class ColorFactory extends AbstractFactory {
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }

    public Shape getShape(String shape) {
        return null;
    }
}
