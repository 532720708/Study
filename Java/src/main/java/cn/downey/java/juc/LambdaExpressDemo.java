package cn.downey.java.juc;

/**
 * 有且仅有一个方法的接口称为函数式接口，可以使用lambda表达式
 */
@FunctionalInterface
interface Foo {
    public int add(int x, int y, int z);

    default int div(int x, int y) {
        return x / y;
    }

    public static int div2(int x, int y) {
        return x * y;
    }
}

/**
 * 2    Lambda Express
 * 2.1口诀：
 * 拷贝小括号，写死右箭头，落地大括号
 * <p>
 * 2.2 @FunctionalInterface
 * 2.3 default
 * 2.4 静态方法实现
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {
//        Foo foo = new Foo() {
//            @Override
//            public void sayHello() {
//                System.out.println("Hello");
//            }
//        };
//        foo.sayHello();

        //
        Foo foo = (x, y, z) -> x + y + z;
        System.out.println(foo.add(1, 2, 3));
        System.out.println(foo.div(10, 5));
        System.out.println(Foo.div2(3, 5));
    }
}
