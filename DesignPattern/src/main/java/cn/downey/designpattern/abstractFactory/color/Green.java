package cn.downey.designpattern.abstractFactory.color;

import cn.downey.designpattern.abstractFactory.api.Color;

public class Green implements Color {
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
