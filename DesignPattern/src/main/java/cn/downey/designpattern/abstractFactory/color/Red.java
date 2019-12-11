package cn.downey.designpattern.abstractFactory.color;

import cn.downey.designpattern.abstractFactory.api.Color;

public class Red implements Color {
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
