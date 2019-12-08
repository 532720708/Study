package cn.downey.designpattern.proxy;

/**
 * 当被请求时，使用ProxyImage来获取RealImage类的对象
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("JPG");

        //图像将从磁盘加载
        image.display();
        System.out.println("");
        //图像不需要从磁盘加载
        image.display();
    }
}
