package cn.downey.java.jvm;


class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * @author zsj53
 */
public class TestTransferValue {

    public void changeValue1(int age) {
        age = 30;
    }

    public void changeValue2(Person person) {
        person.setName("xxx");
    }

    public void changeValue3(String str) {
        str = "xxx";
    }

    public static void main(String[] args) {
        TestTransferValue test = new TestTransferValue();

        //基本类型传复印件
        int age = 20;
        test.changeValue1(age);
        System.out.println("age:\t" + age);

        //引用类型传内存地址
        Person person = new Person("abc");
        test.changeValue2(person);
        System.out.println("personName:\t" + person.getName());

        String str = "abc";
        test.changeValue3(str);
        System.out.println("String:\t" + str);
    }
}
