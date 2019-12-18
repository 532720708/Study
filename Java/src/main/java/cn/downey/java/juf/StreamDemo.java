package cn.downey.java.juf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private Integer id;
    private String username;
    private int age;
}

/**
 * 题目：请按照给出数据，找出同时满足以下条件的用户，也即以下条件全部满足
 * 1、偶数ID且年龄大于24且用户名转为大写且用户名字母倒排序
 * 2、只输出一个用户名字
 */
public class StreamDemo {
    public static void main(String[] args) {

        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        list
                .stream()
                .filter(t -> t.getId() % 2 == 0 && t.getAge() > 24)
                .map(x -> x.getUsername().toUpperCase())
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .forEach(System.out::println);
    }

}
