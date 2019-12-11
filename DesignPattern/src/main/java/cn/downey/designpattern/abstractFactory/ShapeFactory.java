package cn.downey.designpattern.abstractFactory;

import cn.downey.designpattern.abstractFactory.api.Color;
import cn.downey.designpattern.abstractFactory.api.Shape;
import cn.downey.designpattern.abstractFactory.shape.Circle;
import cn.downey.designpattern.abstractFactory.shape.Rectangle;
import cn.downey.designpattern.abstractFactory.shape.Square;

public class ShapeFactory extends AbstractFactory {
    public Color getColor(String color) {
        return null;
    }

    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
