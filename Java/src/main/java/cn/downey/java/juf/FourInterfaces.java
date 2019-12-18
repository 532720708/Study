package cn.downey.java.juf;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 四大函数式接口
 */
public class FourInterfaces {
    public static void main(String[] args) {
        //函数型接口，参数类型T，返回类型R
        Function<String, Integer> function = String::length;
        System.out.println(function.apply("Function"));

        //断定型接口，参数类型T，返回类型Boolean
        Predicate<String> predicate = String::isEmpty;
        System.out.println(predicate.test("Predicate"));

        //消费型接口，参数类型T，返回类型void
        Consumer<String> consumer = System.out::println;
        consumer.accept("Consumer");

        //供给型接口，参数类型无，返回类型T
        Supplier<String> supplier = () -> "Supplier";
        System.out.println(supplier.get());

    }
}
